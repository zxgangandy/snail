

package com.github.snail.common.web;

import com.github.snail.common.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BaseController {
    @Autowired
    private HttpServletRequest request;
    protected org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @return 角色名
     */
    public List<String> getRole() {
        return UserUtils.getRole(request);
    }

    /**
     * 根据请求heard中的token获取用户ID
     *
     * @return 用户ID
     */
    public Integer getUserId() {
        return UserUtils.getUserId(request);
    }


}
