
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _timer1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _pnlsplash = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlhome = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _scrlvsent = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _scrlvqueue = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _tabstrip1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabStripViewPager");
public static RemoteObject _paneltop = RemoteObject.createImmutable(0);
public static RemoteObject _panelheight = RemoteObject.createImmutable("");
public static RemoteObject _count = RemoteObject.createImmutable(0);
public static b4a.example.starter _starter = null;
public static b4a.example.messaging _messaging = null;
public static b4a.example.add _add = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"Add",Debug.moduleToString(b4a.example.add.class),"count",main._count,"Messaging",Debug.moduleToString(b4a.example.messaging.class),"PanelHeight",main.mostCurrent._panelheight,"paneltop",main._paneltop,"PnlHome",main.mostCurrent._pnlhome,"PnlSplash",main.mostCurrent._pnlsplash,"ScrlvQueue",main.mostCurrent._scrlvqueue,"ScrlvSent",main.mostCurrent._scrlvsent,"Starter",Debug.moduleToString(b4a.example.starter.class),"TabStrip1",main.mostCurrent._tabstrip1,"timer1",main._timer1};
}
}