package com.shinoow.acblocks.common.schematics;

/* BlocPos class is classic in 1.8+ version */
/**
 * Copied from Ternsip's Placemod mod.<br>
 * Original file can be found at https://github.com/ternsip/Placemod-1.7.10/blob/master/src/main/java/com/ternsip/placemod/BlockPos.java
 *
 */
public class BlockPos {

    private int x, y, z;

    public BlockPos(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getZ() {
        return z;
    }

}