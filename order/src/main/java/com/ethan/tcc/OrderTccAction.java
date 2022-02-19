package com.ethan.tcc;

import com.ethan.entity.Order;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface OrderTccAction {
    @TwoPhaseBusinessAction(name="orderAction",commitMethod = "commit",rollbackMethod = "rollback")
    boolean createOrder(BusinessActionContext businessActionContext,
                        @BusinessActionContextParameter(paramName = "order") Order order);
    boolean commit(BusinessActionContext businessActionContext);
    boolean rollback(BusinessActionContext businessActionContext);
}
