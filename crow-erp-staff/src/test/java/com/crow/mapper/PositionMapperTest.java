package com.crow.mapper;

import com.crow.model.Columnar;
import com.crow.model.ColumnarList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PositionMapperTest {
    @Autowired
    private PositionMapper positionMapper;

    @Test
    void test(){
        Columnar[] columnars = positionMapper.columnarPosition();
        ColumnarList columnarList = new ColumnarList();

        for (int i = 0; i < columnars.length; i++) {
            columnarList.getNameList().add(columnars[i].getName());
            columnarList.getCountList().add(columnars[i].getCount());
        }

        System.out.println(columnarList);
    }
}