/**
 * ��� ����� �࠭�� ������� ���ﭨ�, ����室���� ������� A* ��� ���᫥��� a
 * ���� �� ����.  �� ���ﭨ� ����砥� � ᥡ� ����� "������� ��⥢�� �祪" �
 * �� ���� �������� "�������� ��⥢�� �祪"."�஬� ⮣�, ��� ����� ���ᯥ稢���
 * �᭮��� ����樨, ����室��� ������� ���᪠ ��� ��� �믮������ ���
 * ��ࠡ�⪨.
 **/
 
 import java.util.*;
 
public class AStarState
{
    /** �� ��뫪� �� �����, �� ���ன ��६�頥��� ������ A*. **/
    private Map2D map;

	private HashMap<Location, Waypoint> openVertex = new HashMap<Location, Waypoint>();
	private HashMap<Location, Waypoint> closeVertex = new HashMap<Location, Waypoint>();
	

    /**
     * ���樠������� ���� ��ꥪ� ���ﭨ� ��� �ᯮ�짮����� �����⬠ ���᪠ ��� A*.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** �����頥� �����, �� ���ன ��६�頥��� �������� A* **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * ��� ��⮤ ᪠����� �� ������ ��⥢� �窨 � �����頥� ��⥢�� ���.
     * � ��������묨 ��騬� ����⠬�.  �᫨ ��� ������� ��⥢�� �祪, ��� ��⮤
     * �����頥� <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
		
		//System.out.println("getMinOpenWaypoint called!");
        if (openVertex.isEmpty()) return null;	
		
		float minCost = 3.4e+38f;
		Waypoint minCostObject = null;
		
		ArrayList<Waypoint> values = new ArrayList<Waypoint>(openVertex.values());
		for (Waypoint element : values) {
			if (element.getTotalCost() < minCost) {
				minCost = element.getTotalCost();
				minCostObject = element;
			}
		}
		
		//System.out.println("\tminWaypoint coords: " + minCostObject.getLocation().xCoord + ", " + minCostObject.getLocation().yCoord + ", cost = " + minCost);
		return minCostObject;
    }

    /**
     * ��� ��⮤ �������� ��⥢�� ��� � (��� ��⥭樠�쭮 �������� 㦥 ����������
     * �) �������� "������ ��⥢� �窨".  �᫨ �� ��� ����⮣�
     * * ��⥢�� �窠 � ����� ���⮯�������� ��⥢�� �祪, � ����� ��⥢�� �窠 ����
     * ��������� � ��������.  ������, �᫨ 㦥 ������� ��⥢�� �窠 ��
     * * ����� �ᯮ������� ��⥢�� �祪, ����� ��⥢�� �窠 ������� ⮫쪮 �����
     * * �᫨ ����� ���祭�� ��⥢�� �祪 "�।���� �⮨�����" ����� ⥪�饣�
     * * ��⥢� �窨" �।���� �⮨����� " ���祭��.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
		//System.out.println("addOpenWaypoint called!");
		
		// ����祭�� ��� ���祩 �� HashMap
		ArrayList<Location> locations = new ArrayList<Location>(openVertex.keySet());
		
		// ����祭�� Location �室�饣� Waypoint
		Location newLoc = newWP.getLocation();
		//System.out.println("\tnew waypoint coords: " + newLoc.xCoord + ", " + newLoc.yCoord);
		
		//��ᬮ�� ��� ���祩 �� locations
		for (Location index : locations) {
			if (newLoc.equals(index)) {
				// �⠤�� 2 - �ࠢ����� �⮨���⥩, �.�. index == newLoc
				
				// �᫨ �⮨����� ��� �� newWP ����� �⮨���� ��� �� ���設� � ⠪�� �� Location - �����塞
				Waypoint oldWP = openVertex.get(index);
				//System.out.println("\tthere is equal point: " + index.xCoord + ", " + index.yCoord);
				double oldCost = oldWP.getPreviousCost();
				double newCost = newWP.getPreviousCost();
				//System.out.println("\told cost: " + oldCost + ", new cost: " + newCost);
				
				if (newCost < oldCost) {
					openVertex.put(newLoc, newWP);
					return true;
				}
				
				// �᫨ ����� ���設� �� ����諠
				return false;
				
			}
		}
		
		openVertex.put(newLoc, newWP);
		//System.out.println("\tnew point opened");
		return true;
    }


    /** �����頥� ⥪�饥 ������⢮ ������� ��⥢�� �祪. **/
    public int numOpenWaypoints()
    {
        return openVertex.size();
    }


    /**
     * ��� ��⮤ ��६�頥� ��⥢�� ��� � 㪠������ ���� ��
     ** ����⮣� ᯨ᮪� � ������� ᯨ᮪.
     **/
    public void closeWaypoint(Location loc)
    {
		//System.out.println("Closing waypoint: " + loc.xCoord + ", " + loc.yCoord);
        Waypoint wp = openVertex.get(loc);
		openVertex.remove(loc);
		closeVertex.put(loc, wp);
    }

    /**
     * �����頥� true, �᫨ �������� �������� ��⥢�� �祪 ᮤ�ন� ��⥢�� ���
     ** ��� 㪠������� ����.
     **/
    public boolean isLocationClosed(Location loc)
    {
       return openVertex.containsKey(loc);
    }
}