package xmu.oomall.util;

import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author fenggqc
 * @date 2016/6/29
 */
public class Copyer {
    public static <B, S extends B> boolean Copy(B bo, S so) {
        try {
            if (bo == null) {
                so = null;
                return false;
            }
            if (so == null) {
                return false;
            }
            Class bc = bo.getClass();
            DeserializeBeanInfo deserializeBeanInfo = DeserializeBeanInfo.computeSetters(so.getClass(), (Type) so.getClass());
            List<FieldInfo> getters = TypeUtils.computeGetters(bo.getClass(), null);
            List<FieldInfo> setters = deserializeBeanInfo.getFieldList();
            Object v;
            FieldInfo getterfield;
            FieldInfo setterfidld;
            for (int j = 0; j < getters.size(); j++) {
                getterfield = getters.get(j);
                for (int i = 0; i < setters.size(); i++) {
                    setterfidld = setters.get(i);
                    if (setterfidld.getName().compareTo(getterfield.getName()) == 0) {
                        v = getterfield.getMethod().invoke(bo);
                        setterfidld.getMethod().invoke(so, v);
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return true;
    }
}
