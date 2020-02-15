/**
 * ��� ����� �࠭�� ������� ���ﭨ�, ����室���� ������� A* ��� ���᫥��� a
 * ���� �� ����.  �� ���ﭨ� ����砥� � ᥡ� ����� "������� ��⥢�� �祪" �
 * �� ���� �������� "�������� ��⥢�� �祪"."�஬� ⮣�, ��� ����� ���ᯥ稢���
 * �᭮��� ����樨, ����室��� ������� ���᪠ ��� ��� �믮������ ���
 * ��ࠡ�⪨.
 **/
public class AStarState
{
    /** �� ��뫪� �� �����, �� ���ன ��६�頥��� ������ A*. **/
    private Map2D map;


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
    public Waypoint getMinOpenWaypoint()
    {
        // TODO:  Implement.
        return null;
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
        // TODO:  Implement.
        return false;
    }


    /** �����頥� ⥪�饥 ������⢮ ������� ��⥢�� �祪. **/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.
        return 0;
    }


    /**
     * ��� ��⮤ ��६�頥� ��⥢�� ��� � 㪠������ ���� ��
     ** ����⮣� ᯨ᮪� � ������� ᯨ᮪.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
    }

    /**
     * �����頥� true, �᫨ �������� �������� ��⥢�� �祪 ᮤ�ন� ��⥢�� ���
     ** ��� 㪠������� ����.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
        return false;
    }
}