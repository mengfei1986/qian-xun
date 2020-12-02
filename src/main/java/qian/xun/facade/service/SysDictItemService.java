package qian.xun.facade.service;

import qian.xun.facade.po.SysDict;
import qian.xun.facade.po.SysDictItem;
import qian.xun.facade.query.SysDictItemQuery;
import qian.xun.facade.request.SysDictItemRequest;
import qian.xun.facade.response.PageResult;

import java.util.List;

public interface SysDictItemService {
    PageResult<SysDictItem> pageList(SysDictItemRequest.PageList req);
    int insert(SysDictItem sysDictItem);
    boolean update(SysDictItem sysDictItem);
    boolean delete(int id);
}
