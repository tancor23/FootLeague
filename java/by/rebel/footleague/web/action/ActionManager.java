package by.rebel.footleague.web.action;

import java.util.Map;

public final class ActionManager {

	private ActionManager() {
	}

	private static Map<String, BaseAction> actions;

	public static BaseAction getAction(String action) {
		return actions.get(action);
	}
}
