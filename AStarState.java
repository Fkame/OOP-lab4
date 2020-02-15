/**
 * Этот класс хранит базовое состояние, необходимое алгоритму A* для вычисления a
 * путь по карте.  Это состояние включает в себя набор "открытых путевых точек" и
 * еще одна коллекция "закрытых путевых точек"."Кроме того, этот класс обеспечивает
 * основные операции, необходимые алгоритму поиска пути для выполнения его
 * обработки.
 **/
 
 import java.util.*;
 
public class AStarState
{
    /** Это ссылка на карту, по которой перемещается алгоритм A*. **/
    private Map2D map;

	private HashMap<Location,Waypoint> openVertex = new HashMap<Location, Waypoint>();
	private HashMap<Location, Waypoint> closeVertex = new HashMap<Location, Waypoint>();
	

    /**
     * Инициализируйте новый объект состояния для использования алгоритма поиска пути A*.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Возвращает карту, по которой перемещается навигатор A* **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * Этот метод сканирует все открытые путевые точки и возвращает путевую точку.
     * с минимальными общими затратами.  Если нет открытых путевых точек, этот метод
     * возвращает <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
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
		
		return minCostObject;
    }

    /**
     * Этот метод добавляет путевую точку К (или потенциально обновляет уже существующую
     * в) Коллекция "открытые путевые точки".  Если еще нет открытого
     * * путевая точка в новом местоположении путевых точек, то новая путевая точка просто
     * добавлено в коллекцию.  Однако, если уже имеется путевая точка на
     * * новое расположение путевых точек, новая путевая точка заменяет только старую
     * * если новое значение путевых точек "предыдущая стоимость" меньше текущего
     * * путевые точки" предыдущая стоимость " значение.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
        return false;
    }


    /** Возвращает текущее количество открытых путевых точек. **/
    public int numOpenWaypoints()
    {
        return openVertex.size();
    }


    /**
     * Этот метод перемещает путевую точку в указанное место из
     ** открытого списока в закрытый список.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
    }

    /**
     * Возвращает true, если коллекция закрытых путевых точек содержит путевую точку
     ** для указанного места.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
        return false;
    }
}