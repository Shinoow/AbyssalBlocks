package com.shinoow.acblocks.common.schematics;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

/* Reflects information about cuboid stereometric state in the world. */
/**
 * Copied from Ternsip's Placemod mod.<br>
 * Original file can be found at https://github.com/ternsip/Placemod-1.8/blob/master/src/main/java/com/ternsip/placemod/Posture.java
 *
 */
class Posture {

    private int posX, posY, posZ;
    private int rotateX, rotateY, rotateZ;
    private boolean flipX, flipY, flipZ;
    private int width, height, length;
    private int sizeX, sizeY, sizeZ;
    private int endX, endY, endZ;

    Posture(int posX, int posY, int posZ,
            int rotateX, int rotateY, int rotateZ,
            boolean flipX, boolean flipY, boolean flipZ,
            int width, int height, int length) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.rotateX = (rotateX % 4 + 4) % 4;
        this.rotateY = (rotateY % 4 + 4) % 4;
        this.rotateZ = (rotateZ % 4 + 4) % 4;
        this.flipX = flipX;
        this.flipY = flipY;
        this.flipZ = flipZ;
        this.width = width;
        this.height = height;
        this.length = length;
        update();
    }

    void shift(int dx, int dy, int dz) {
        this.posX += dx;
        this.posY += dy;
        this.posZ += dz;
        update();
    }

    private void update() {
        this.sizeX = width;
        this.sizeY = height;
        this.sizeZ = length;
        if (rotateX % 2 > 0) {
            int tmp = sizeY; sizeY = sizeZ; sizeZ = tmp;
        }
        if (rotateY % 2 > 0) {
            int tmp = sizeX; sizeX = sizeZ; sizeZ = tmp;
        }
        if (rotateZ % 2 > 0) {
            int tmp = sizeX; sizeX = sizeY; sizeY = tmp;
        }
        this.endX = posX + sizeX;
        this.endY = posY + sizeY;
        this.endZ = posZ + sizeZ;
    }

    /* Get world position of structure index(x,y,z) block */
    BlockPos getWorldPos(int x, int y, int z) {
        int wx = flipX ? width - x - 1 : x;
        int wy = flipY ? height - y - 1 : y;
        int wz = flipZ ? length - z - 1 : z;
        int w = width, h = height, l = length;
        /* ADD X rotations */
        /* ADD Z rotations */
        for (int i = 0; i < rotateY; ++i) {
            int tmp = wz; wz = w - wx - 1; wx = tmp; tmp = w; w = l; l = tmp;
        }
        return new BlockPos(wx + posX, wy + posY, wz + posZ);
    }

    /* Get world metadata of block with metadata */
    int getWorldMeta(Block block, byte meta) {
        Directions.BlockType blockType = Directions.getBlockType(block, meta);
        int mask = Directions.getMask(blockType);
        int overlap = (meta & mask) ^ meta;
        int direction = Directions.getDirection(meta & mask, blockType);
        int[] rotationsY = {Directions.EAST, Directions.NORTH, Directions.WEST, Directions.SOUTH};
        /* ADD X rotations */
        /* ADD Z rotations */
        /* ADD Y flip */
        int rotY = rotateY;
        rotY += (flipX && (direction == Directions.WEST || direction == Directions.EAST)) ? 2 : 0;
        rotY += (flipZ && (direction == Directions.SOUTH || direction == Directions.NORTH)) ? 2 : 0;
        rotY = (4 + rotY % 4) % 4;
        if (direction == Directions.EAST) {
            return Directions.getMeta(meta, rotationsY[rotY % 4], blockType) | overlap;
        }
        if (direction == Directions.NORTH) {
            return Directions.getMeta(meta, rotationsY[(1 + rotY) % 4], blockType) | overlap;
        }
        if (direction == Directions.WEST) {
            return Directions.getMeta(meta, rotationsY[(2 + rotY) % 4], blockType) | overlap;
        }
        if (direction == Directions.SOUTH) {
            return Directions.getMeta(meta, rotationsY[(3 + rotY) % 4], blockType) | overlap;
        }
        return meta | overlap;
    }

    int getPosX() {
        return posX;
    }

    int getPosY() {
        return posY;
    }

    int getPosZ() {
        return posZ;
    }

    int getRotateX() {
        return rotateX;
    }

    int getRotateY() {
        return rotateY;
    }

    int getRotateZ() {
        return rotateZ;
    }

    boolean isFlipX() {
        return flipX;
    }

    boolean isFlipY() {
        return flipY;
    }

    boolean isFlipZ() {
        return flipZ;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    int getLength() {
        return length;
    }

    int getSizeX() {
        return sizeX;
    }

    int getSizeY() {
        return sizeY;
    }

    int getSizeZ() {
        return sizeZ;
    }

    int getEndX() {
        return endX;
    }

    int getEndY() {
        return endY;
    }

    int getEndZ() {
        return endZ;
    }

    int getIndex(int x, int y, int z) {
        return x + y * width * length + z * width;
    }

    int getX(int index) {
        return index % width;
    }

    int getY(int index) {
        return index / (width * length);
    }

    int getZ(int index) {
        return (index / width) % length;
    }

    int getStartChunkX() {
        return posX / 16 + (posX < 0 ? -1 : 0);
    }

    int getStartChunkZ() {
        return posZ / 16 + (posZ < 0 ? -1 : 0);
    }

    int getEndChunkX() {
        return getEndX() / 16 + (getEndX() < 0 ? -1 : 0);
    }

    int getEndChunkZ() {
        return getEndZ() / 16 + (getEndZ() < 0 ? -1 : 0);
    }

}