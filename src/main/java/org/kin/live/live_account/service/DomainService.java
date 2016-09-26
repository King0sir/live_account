package org.kin.live.live_account.service;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.GroupingSetExpr;
import org.kin.live.live_account.dao.GroupsMapper;
import org.kin.live.live_account.domain.Groups;
import org.kin.live.live_account.domain.GroupsExample;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.except.extend.GroupsException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by kingsir on 16-9-26.
 */
@Service
public class DomainService {

    @Resource
    private GroupsMapper groupsMapper;

    public Groups queryGroupsByUserId(String userId) throws BaseException {
        GroupsExample example = new GroupsExample();
        GroupsExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Groups> groupsList = groupsMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(groupsList)){
            BaseException.throwExcept(GroupsException.class, GroupsException.ExceptCode.NoGroup.getMessage());
        }
        return groupsList.get(0);
    }
}
