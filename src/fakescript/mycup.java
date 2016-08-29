package fakescript;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import fakescript.syntree.func_desc_node;
import fakescript.syntree.syntree_node;

public class mycup
{
	private fake m_f;
	private String m_filename = "";
	private String m_packagename = "";
	private ArrayList<String> m_includelist = new ArrayList<String>();
	private HashSet<String> m_struct_list = new HashSet<String>();
	private HashMap<String, syntree_node> m_constmap = new HashMap<String, syntree_node>();
	private ArrayList<func_desc_node> m_funclist = new ArrayList<func_desc_node>();
	private jflex m_j;

	public mycup(fake f, jflex j)
	{
		m_f = f;
		m_j = j;
	}

	public fake get_fake()
	{
		return m_f;
	}

	public jflex get_jflex()
	{
		return m_j;
	}

	public String get_filename()
	{
		return m_filename;
	}

	public void set_filename(String filename)
	{
		m_filename = filename;
	}

	public String get_package()
	{
		return m_packagename;
	}

	public void set_package(String packagename)
	{
		m_packagename = packagename;
	}

	public void add_include(String includefile)
	{
		// 加入include list，等待解析完再统一挨个include
		m_includelist.add(includefile);
	}

	public ArrayList<String> get_include_list()
	{
		return m_includelist;
	}

	public void add_struct_desc(String structname)
	{
		m_struct_list.add(structname);
	}

	boolean is_have_struct(String structname)
	{
		return m_struct_list.contains(structname);
	}

	public HashMap<String, syntree_node> get_const_map()
	{
		return m_constmap;
	}

	public void add_const_desc(String name, syntree_node node)
	{
		m_constmap.put(name, node);
		types.log(m_f, "add_const_desc " + name + " " + node.dump(0));
	}

	public void add_func_desc(func_desc_node p)
	{
		types.log(m_f, "add_func_desc " + p.m_funcname);
		types.log(m_f, "func " + p.m_funcname + " dump " + p.dump(0));
		m_funclist.add(p);
	}

	public ArrayList<func_desc_node> get_func_list()
	{
		return m_funclist;
	}

	public boolean is_have_func(String funcname)
	{
		for (int i = 0; i < (int) m_funclist.size(); i++)
		{
			func_desc_node p = m_funclist.get(i);
			if (p.m_funcname.equals(funcname))
			{
				return true;
			}
		}
		return false;
	}
}
