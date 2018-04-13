
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class searchview {
    public static RemoteObject myClass;
	public searchview() {
	}
    public static PCBA staticBA = new PCBA(null, searchview.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _prefixlist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _substringlist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _et = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _min_limit = RemoteObject.createImmutable(0);
public static RemoteObject _max_limit = RemoteObject.createImmutable(0);
public static RemoteObject _mcallback = RemoteObject.declareNull("Object");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _allitems = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _ime = RemoteObject.declareNull("anywheresoftware.b4a.objects.IME");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.messaging _messaging = null;
public static b4a.example.add _add = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"allItems",_ref.getField(false, "_allitems"),"et",_ref.getField(false, "_et"),"IME",_ref.getField(false, "_ime"),"lv",_ref.getField(false, "_lv"),"MAX_LIMIT",_ref.getField(false, "_max_limit"),"mCallback",_ref.getField(false, "_mcallback"),"mEventName",_ref.getField(false, "_meventname"),"MIN_LIMIT",_ref.getField(false, "_min_limit"),"prefixList",_ref.getField(false, "_prefixlist"),"substringList",_ref.getField(false, "_substringlist")};
}
}