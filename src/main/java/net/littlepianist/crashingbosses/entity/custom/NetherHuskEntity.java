package net.littlepianist.crashingbosses.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkHooks;

import java.util.Random;


public class NetherHuskEntity extends Husk {
    public NetherHuskEntity(EntityType<? extends Husk> p_32889_, Level p_32890_) {
        super(p_32889_, p_32890_);
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20D);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    @Override
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }


    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
    }

    class AttackTurtleEggGoal extends RemoveBlockGoal {
        AttackTurtleEggGoal(PathfinderMob creatureIn, double speed, int yMax) {
            super(Blocks.TURTLE_EGG, creatureIn, speed, yMax);
        }

        public void playDestroyProgressSound(LevelAccessor worldIn, BlockPos pos) {
            worldIn.playSound((Player)null, pos, SoundEvents.ZOMBIE_DESTROY_EGG, SoundSource.HOSTILE, 0.5F, 0.9F + NetherHuskEntity.this.random.nextFloat() * 0.2F);
        }

        public void playBreakSound(Level worldIn, BlockPos pos) {
            worldIn.playSound((Player)null, pos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.7F, 0.9F + worldIn.random.nextFloat() * 0.2F);
        }

        public double acceptedDistance() {
            return 1.14D;
        }
    }

    public static boolean canSpawnHere(EntityType<NetherHuskEntity> p_223334_0_, ServerLevelAccessor p_223334_1_, MobSpawnType reason, BlockPos p_223334_3_, Random p_223334_4_) {
        return checkMonsterSpawnRules(p_223334_0_, p_223334_1_, reason, p_223334_3_, p_223334_4_) && (reason == MobSpawnType.SPAWNER || p_223334_1_.canSeeSky(p_223334_3_));
    }
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}

