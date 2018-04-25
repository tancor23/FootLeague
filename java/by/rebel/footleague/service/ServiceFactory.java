package by.rebel.footleague.service;

import by.rebel.footleague.service.impl.MatchServiceImpl;
import by.rebel.footleague.service.impl.PlayerServiceImpl;

public class ServiceFactory {
	
	public static PlayerService getCarService() {
		return new PlayerServiceImpl();
	}
	
	public static MatchService getOrderService() {
		return new MatchServiceImpl();
	}

}
