package qian.xun.facade.service;

import qian.xun.facade.po.SysDict;
import qian.xun.facade.po.User;
import qian.xun.facade.request.SysDictRequest;
import qian.xun.facade.response.PageResult;

import java.util.List;

public interface SysDictService {
    List<SysDict> queryList(SysDictRequest.QueryList query);
    PageResult<SysDict> pageList(SysDictRequest.PageList query);
    int insert(SysDict sysDict);
    boolean update(SysDict sysDict);
    boolean delete(int id);
}
