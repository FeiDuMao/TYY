package com.tyy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {


    @Qualifier("redisTemplate")
    @Autowired
    RedisTemplate template;

//    @Autowired
//    RedisScript<Boolean> script;

    public <T> void setCacheObject(final String key, final T value)
    {
        template.opsForValue().set(key, value);
    }
    public <T> void setCacheObject(final String key, final T value,long time)
    {
        template.opsForValue().set(key, value,time,TimeUnit.SECONDS);
    }

    public <T> T getCacheObject(final String key)
    {
        ValueOperations<String, T> operation = template.opsForValue();
        return operation.get(key);
    }





    public long deleteObject(final Collection collection)
    {
        return template.delete(collection);
    }



    public Boolean setLock(Principal principal){
        return template.opsForValue().setIfAbsent("lock", principal.getName(), 120, TimeUnit.SECONDS);
    }

    public Boolean unLock(Principal principal){

        if (this.getCacheObject("lock").equals(principal.getName())) {
            this.deleteObject(Collections.singleton("lock"));
            return true;
        }else {
            return false;
        }


        //return (Boolean)template.execute(script,Collections.singletonList("lock"),principal.getName());
    }



}
