package com.dev.java.enumm;

import com.dev.java.enumm.case1.TableStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableStatusTest {

    private TableStatus selectFromOriginTable() {
        return TableStatus.Y;
    }
    @Test
    public void origin테이블에서_조회한_데이터를_다른_2테이블에_등록한다() {
        TableStatus origin = selectFromOriginTable();
        String table1Value = origin.getTable1Value();
        boolean table2Value = origin.isTable2Value();

        assertThat(origin).isEqualTo(TableStatus.Y);
        assertThat(table1Value).isEqualTo("1");
        assertThat(table2Value).isEqualTo(true);
    }
}