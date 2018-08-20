package org.smart4j.chapter3;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;

@Controller
public class Test {
@Action("get:/test")
public Data test(Param param) {
	Bean o=new Bean("dd","23");
	Data data=new Data(o);
	return data;
}
@Action("get:/ab")
public Data ab(Bean bean,Bean2 b,String sex) {
	Data data=new Data(bean);
	return data;
}
}
