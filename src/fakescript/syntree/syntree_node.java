package fakescript.syntree;

import fakescript.fake;

public class syntree_node 
{
	public fake m_f = null;
	public int m_lno = 0;

	public syntree_node()
	{
		
	}
	
	public esyntreetype gettype()
	{
		return esyntreetype.est_nil;
	}
	
	public String gettypename()
	{
		return gettype().toString();
	}
	
	public String dump(int indent)
	{
		return gentab(indent) + "nil\n";
	}

	public String gentab(int indent)
	{
		String ret = "";
		ret += "LINE:";
		ret += m_lno;
		ret += " ";
		for (int i = 0; i < indent; i++)
		{
			ret += "\t";
		}
		return ret;
	}

	public int lineno()
	{
		return m_lno;
	}

}