
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class add implements IRemote{
	public static add mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public add() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("add"), "b4a.example.add");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, add.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _alarmtime = RemoteObject.createImmutable(0L);
public static RemoteObject _alarmdate = RemoteObject.createImmutable(0L);
public static RemoteObject _booldate = RemoteObject.createImmutable(false);
public static RemoteObject _booltime = RemoteObject.createImmutable(false);
public static RemoteObject _lbldate = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbltime = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _txtcontacts = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lstcontacts = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _pnlcontact = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cu = RemoteObject.declareNull("b4a.example.contactsutils");
public static RemoteObject _selected = RemoteObject.createImmutable(false);
public static RemoteObject _clist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _pansend = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _edittext2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.messaging _messaging = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",add.mostCurrent._activity,"alarmdate",add._alarmdate,"alarmtime",add._alarmtime,"boolDate",add._booldate,"boolTime",add._booltime,"Clist",add.mostCurrent._clist,"cu",add.mostCurrent._cu,"EditText2",add.mostCurrent._edittext2,"LblDate",add.mostCurrent._lbldate,"LblTime",add.mostCurrent._lbltime,"LstContacts",add.mostCurrent._lstcontacts,"Main",Debug.moduleToString(b4a.example.main.class),"Messaging",Debug.moduleToString(b4a.example.messaging.class),"panSend",add.mostCurrent._pansend,"PnlContact",add.mostCurrent._pnlcontact,"selected",add._selected,"Starter",Debug.moduleToString(b4a.example.starter.class),"TxtContacts",add.mostCurrent._txtcontacts};
}
}