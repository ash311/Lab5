package pkgPokerBLL;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Table implements Serializable {

	private UUID TableID;

	// Change this from ArrayList to HashMap.
	private HashMap<UUID, Player> hmPlayer = new HashMap<UUID, Player>();

	public Table() {
		super();
		TableID = UUID.randomUUID();
	}

	public Table AddPlayerToTable(Player p) {
		hmPlayer.put(p.getPlayerID(), p);
		return this;
	}

	public Table RemovePlayerFromTable(Player p) {
		hmPlayer.remove(p.getPlayerID());
		return this;
	}

	public HashMap<UUID, Player> getHmPlayer() {
		return hmPlayer;
	}
	
	public HashMap getHashPlayers() {
		return hmPlayer;
	}
	
	public Player getPlayerByPosition(int iPlayerPosition)
	{
		Player pl = null;
		
		Iterator it = getHashPlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Player p = (Player)pair.getValue();
			if (p.getiPlayerPosition() == iPlayerPosition)
				pl = p;
		}
		
		return pl;
	}
	
	public Player PickRandomPlayerAtTable()
	{
		List<Player> listPlayers = new ArrayList<Player>(getHashPlayers().values());
		Collections.shuffle(listPlayers);
		return listPlayers.get(0);
		
	}
	public static Table CloneTable(Table t)
	{
		Table t1 = new Table();
		t1.TableID = t.TableID;
		Iterator it = t.getHashPlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			t1.AddPlayerToTable((Player)pair.getValue());
		}
		
		return t1;
	}
	
	public static void StateOfTable(Table t)
	{
		System.out.println("----------------------");
		System.out.println("Table : " + t.TableID);
		System.out.println("Table Nbr of Players: " + t.getHashPlayers().size());
		Iterator it = t.getHashPlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Player p = (Player)pair.getValue();
			
			System.out.println("Player ID: " + p.getPlayerID().toString());
			System.out.println("Player Position: " + p.getiPlayerPosition());
			System.out.println("Player Name: " + p.getPlayerName());
			System.out.println("----------------------");
		}
		
		System.out.println("----------------------");
		System.out.println(" ");
	}
	
}
