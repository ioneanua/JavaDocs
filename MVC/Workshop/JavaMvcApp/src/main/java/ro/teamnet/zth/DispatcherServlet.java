package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by user on 7/14/2016.
 */
public class DispatcherServlet extends HttpServlet {

    //rol de registru: key- urlPath, val: inf despre metoda care va procesa acest url
    HashMap<String, MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    @Override
    public void init() throws ServletException {

        try {
            /**
             * Cautare clase din pachet
             */
            Iterable<Class> controllers = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : controllers) {
               if (controller.isAnnotationPresent(MyController.class)){
                   MyController myCtrlAnnotation = (MyController) controller.getAnnotation(MyController.class);

                   //am luat cheia pt hashMap
                   String controllerUrlPath = myCtrlAnnotation.urlPath();
                   Method[] controllerMethods =  controller.getMethods();

                   //acum cautam valoare, verificand daca este prezenta annotarea MyRequestMethod pe met respectiva
                   for (Method controllerMethod : controllerMethods){
                       if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)){
                           MyRequestMethod myRequestMethod = controllerMethod.getAnnotation(MyRequestMethod.class);

                           String methodUrlPath = myRequestMethod.urlPath();

                           //construiesc cheia pt hashMap
                           String urlPath = controllerUrlPath + methodUrlPath;

                           //creeem valoare pt hashMap
                           MethodAttributes methodAttributes = new MethodAttributes();
                           methodAttributes.setControllerClass(controller.getName());
                           methodAttributes.setMethodType(myRequestMethod.methodType());
                           methodAttributes.setMethodName(controllerMethod.getName());

                           allowedMethods.put(urlPath, methodAttributes);
                       }
                   }

               }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("POST", req, resp);
    }

    public void dispatchReply(String identificator, HttpServletRequest request, HttpServletResponse response){

        Object result = null;

        try {
            result = dispatch(request, response);
        } catch (Exception e) {
            sendExceptionError(e, request, response);
        }

        try {
            reply(result, request, response);
        } catch (IOException e) {
            sendExceptionError(e, request, response);
            e.printStackTrace();
        }


    }

    public Object dispatch(HttpServletRequest request, HttpServletResponse response){

        String path = request.getPathInfo();

        MethodAttributes methodAttributes = allowedMethods.get(path);

        if (methodAttributes == null){
            return "Hello";
        }

        String controllerName = methodAttributes.getControllerClass();

        try {
            Class<?> controllerClass = Class.forName(controllerName);
            Object controllerInstance = controllerClass.newInstance();
            Method method = controllerClass.getMethod(methodAttributes.getMethodName());
            Object result = method.invoke(controllerInstance);
            return result;
        } catch (NoSuchMethodException e) {
                    e.printStackTrace();
        } catch (InstantiationException e) {
                e.printStackTrace();
        } catch (IllegalAccessException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return "Hello";
    }

    public void reply(Object result, HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.printf(result.toString());
    }

    public void sendExceptionError(Exception e, HttpServletRequest request, HttpServletResponse response){

    }
}
