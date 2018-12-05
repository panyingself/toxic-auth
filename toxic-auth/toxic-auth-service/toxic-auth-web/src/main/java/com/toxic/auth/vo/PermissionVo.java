package com.toxic.auth.vo;

import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/12/6 0:17.
 */
public class PermissionVo {
    private String name;
    private boolean open;
    private List<ChildrenVo> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<ChildrenVo> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenVo> children) {
        this.children = children;
    }
}
