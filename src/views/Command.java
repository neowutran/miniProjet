package views;

import com.sun.istack.internal.*;
import lib.*;
import model.*;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by draragar on 01/12/13.
 */
public class Command {

    public String getName() {

        return name;
    }

    private String name;

    public List<String> getArgs() {

        return args;
    }

    private List<String> args = new LinkedList<>();
    private String description;
    private State state;
    private String method;

    public Command(@NotNull String name, @NotNull List<String> args, @NotNull State state, @NotNull String method, @NotNull String description) {

        this.name = name;
        this.args = args;
        this.state = state;
        this.method = method;
        this.description = description;

    }

    public void invoke(String[] arg) throws MiniProjectException{

        if (arg.length-1 != this.args.size()) {

            state.printHelp();
            return;
        }

        Method[] methods = ArrayUtils.concatenate(state.getClass().getDeclaredMethods(), state.getClass().getMethods());


        for(Method method: methods){

            if(!method.getName().equals(this.method)){
                continue;
            }

            Class[] parameters = method.getParameterTypes();
            if(parameters.length != args.size()){
                continue;
            }


            Boolean goodMethod = true;

            for(Class parameter: parameters){

                if(!parameter.equals(String.class)){
                    goodMethod = false;
                    break;
                }
            }

            if(goodMethod){

                method.setAccessible(true);
                try {
                    method.invoke(this.state, Arrays.copyOfRange(arg, 1, arg.length));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return;
            }
        }

        throw new MiniProjectException("method not found");

    }

    @Override
    public String toString() {

        String show = "- "+name +" : "+name;
        for(String arg: args){
            show += " "+arg;
        }
        show += "\n";
        show += "\t"+this.description+"\n";

        return show;
    }
}
