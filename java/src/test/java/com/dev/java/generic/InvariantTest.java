package com.dev.java.generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvariantTest {

    @Test
    @DisplayName("")
    void invariantTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Invariant.printList(list);

    }

}