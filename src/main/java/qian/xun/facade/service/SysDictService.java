package qian.xun.facade.service;

import qian.xun.facade.po.SysDict;
import qian.xun.facade.po.User;
import qian.xun.facade.request.SysDictRequest;

import java.util.List;

public interface SysDictService {
    List<SysDict> queryList(SysDictRequest.QueryList query);
    int insert(SysDict sysDict);
    boolean update(SysDict sysDict);
    boolean delete(int id);
}
