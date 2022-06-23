package com.vbuser.btnote.blocks.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPianoSeven extends TileEntity {

    public boolean previousRedstoneState;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setBoolean("powered", this.previousRedstoneState);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.previousRedstoneState = compound.getBoolean("powered");
    }
}
