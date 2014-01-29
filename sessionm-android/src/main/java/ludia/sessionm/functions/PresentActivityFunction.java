package ludia.sessionm.functions;

import android.app.Activity;
import android.content.Intent;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import ludia.sessionm.PresentActivityActivity;
import ludia.sessionm.SessionMExtension;

public class PresentActivityFunction implements FREFunction {

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects)
    {

        SessionMExtension.log("PresentActivityFunction.call()");

        String type = readActivityType(freObjects);

        Activity activity = freContext.getActivity();
        Intent intent = new Intent(activity.getApplicationContext(), PresentActivityActivity.class);
        intent.putExtra("ACT_TYPE", type);

        SessionMExtension.log("Activity type: " + type);

        try {
            activity.startActivity(intent);
        }
        catch (Exception e) {
            SessionMExtension.logError("Error: " + e.toString());
        }

        return null;
    }

    private String readActivityType(FREObject[] freObjects)
    {
        String action = null;

        try
        {
            action = freObjects[0].getAsString();
        }
        //Exception of type FREInvalidObjectException, FREWrongThreadException or  FRETypeMismatchException
        catch (Exception e)
        {
            SessionMExtension.logError("Couldn't retrieve action : " + e.getMessage());
        }
        finally
        {
            return action;
        }
    }
}
