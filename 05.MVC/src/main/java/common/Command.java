package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	void execute(HttpServletRequest requset, HttpServletResponse response);
}
