-- 卡牌系统数据库表结构

-- 卡牌表
CREATE TABLE cards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '卡牌名称',
    type VARCHAR(20) NOT NULL COMMENT '卡牌类型',
    rarity VARCHAR(20) NOT NULL COMMENT '卡牌稀有度',
    level INT DEFAULT 1 COMMENT '卡牌等级',
    attack INT DEFAULT 0 COMMENT '攻击力',
    health INT DEFAULT 0 COMMENT '生命值',
    armor INT DEFAULT 0 COMMENT '护甲',
    magic_resist INT DEFAULT 0 COMMENT '魔法抗性',
    crit_rate DECIMAL(5,4) DEFAULT 0.0000 COMMENT '暴击率',
    crit_damage DECIMAL(5,4) DEFAULT 0.0000 COMMENT '暴击伤害',
    move_speed INT DEFAULT 0 COMMENT '移动速度',
    attack_speed DECIMAL(5,4) DEFAULT 0.0000 COMMENT '攻击速度',
    description TEXT COMMENT '卡牌描述',
    image_url VARCHAR(500) COMMENT '卡牌图片URL',
    icon_url VARCHAR(500) COMMENT '卡牌图标URL',
    cost INT DEFAULT 0 COMMENT '卡牌费用',
    is_active BOOLEAN DEFAULT TRUE COMMENT '是否可用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_type (type),
    INDEX idx_rarity (rarity),
    INDEX idx_level (level)
) COMMENT '卡牌表';

-- 英雄表
CREATE TABLE heroes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '英雄名称',
    profession VARCHAR(20) NOT NULL COMMENT '英雄职业',
    race VARCHAR(20) NOT NULL COMMENT '英雄种族',
    rarity VARCHAR(20) NOT NULL COMMENT '英雄稀有度',
    level INT DEFAULT 1 COMMENT '英雄等级',
    base_attack INT DEFAULT 0 COMMENT '基础攻击力',
    base_health INT DEFAULT 0 COMMENT '基础生命值',
    base_armor INT DEFAULT 0 COMMENT '基础护甲',
    base_magic_resist INT DEFAULT 0 COMMENT '基础魔法抗性',
    base_crit_rate DECIMAL(5,4) DEFAULT 0.0000 COMMENT '基础暴击率',
    base_crit_damage DECIMAL(5,4) DEFAULT 0.0000 COMMENT '基础暴击伤害',
    base_move_speed INT DEFAULT 0 COMMENT '基础移动速度',
    base_attack_speed DECIMAL(5,4) DEFAULT 0.0000 COMMENT '基础攻击速度',
    description TEXT COMMENT '英雄描述',
    image_url VARCHAR(500) COMMENT '英雄图片URL',
    icon_url VARCHAR(500) COMMENT '英雄图标URL',
    cost INT DEFAULT 0 COMMENT '英雄费用',
    is_active BOOLEAN DEFAULT TRUE COMMENT '是否可用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_profession (profession),
    INDEX idx_race (race),
    INDEX idx_rarity (rarity)
) COMMENT '英雄表';

-- 装备表
CREATE TABLE baseEquipments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '装备名称',
    type VARCHAR(20) NOT NULL COMMENT '装备类型',
    rarity VARCHAR(20) NOT NULL COMMENT '装备稀有度',
    level INT DEFAULT 1 COMMENT '装备等级',
    attack_bonus INT DEFAULT 0 COMMENT '攻击力加成',
    health_bonus INT DEFAULT 0 COMMENT '生命值加成',
    armor_bonus INT DEFAULT 0 COMMENT '护甲加成',
    magic_resist_bonus INT DEFAULT 0 COMMENT '魔法抗性加成',
    crit_rate_bonus DECIMAL(5,4) DEFAULT 0.0000 COMMENT '暴击率加成',
    crit_damage_bonus DECIMAL(5,4) DEFAULT 0.0000 COMMENT '暴击伤害加成',
    move_speed_bonus INT DEFAULT 0 COMMENT '移动速度加成',
    attack_speed_bonus DECIMAL(5,4) DEFAULT 0.0000 COMMENT '攻击速度加成',
    description TEXT COMMENT '装备描述',
    image_url VARCHAR(500) COMMENT '装备图片URL',
    icon_url VARCHAR(500) COMMENT '装备图标URL',
    cost INT DEFAULT 0 COMMENT '装备费用',
    is_combinable BOOLEAN DEFAULT FALSE COMMENT '是否可合成',
    materials TEXT COMMENT '合成材料列表',
    is_active BOOLEAN DEFAULT TRUE COMMENT '是否可用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_type (type),
    INDEX idx_rarity (rarity),
    INDEX idx_level (level)
) COMMENT '装备表';

-- 技能表
CREATE TABLE skills (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '技能名称',
    type VARCHAR(20) NOT NULL COMMENT '技能类型',
    level INT DEFAULT 1 COMMENT '技能等级',
    description TEXT COMMENT '技能描述',
    effect TEXT COMMENT '技能效果描述',
    damage INT DEFAULT 0 COMMENT '技能伤害',
    healing INT DEFAULT 0 COMMENT '技能治疗量',
    cooldown INT DEFAULT 0 COMMENT '技能冷却时间',
    cost INT DEFAULT 0 COMMENT '技能消耗',
    range INT DEFAULT 0 COMMENT '技能范围',
    duration INT DEFAULT 0 COMMENT '技能持续时间',
    image_url VARCHAR(500) COMMENT '技能图片URL',
    icon_url VARCHAR(500) COMMENT '技能图标URL',
    is_active BOOLEAN DEFAULT TRUE COMMENT '是否可用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_type (type),
    INDEX idx_level (level)
) COMMENT '技能表';

-- 用户卡牌表
CREATE TABLE user_cards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL COMMENT '用户ID',
    card_id BIGINT NOT NULL COMMENT '卡牌ID',
    quantity INT DEFAULT 1 COMMENT '卡牌数量',
    level INT DEFAULT 1 COMMENT '卡牌等级',
    is_unlocked BOOLEAN DEFAULT TRUE COMMENT '是否已解锁',
    obtain_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '获得时间',
    last_used_time DATETIME COMMENT '最后使用时间',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_user_card (user_id, card_id),
    INDEX idx_user_id (user_id),
    INDEX idx_card_id (card_id)
) COMMENT '用户卡牌表';

-- 英雄技能关联表
CREATE TABLE hero_skills (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    hero_id BIGINT NOT NULL COMMENT '英雄ID',
    skill_id BIGINT NOT NULL COMMENT '技能ID',
    skill_level INT DEFAULT 1 COMMENT '技能等级',
    is_active BOOLEAN DEFAULT TRUE COMMENT '是否激活',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_hero_skill (hero_id, skill_id),
    INDEX idx_hero_id (hero_id),
    INDEX idx_skill_id (skill_id)
) COMMENT '英雄技能关联表';

-- 插入基础数据
INSERT INTO cards (name, type, rarity, level, attack, health, armor, cost, description) VALUES
('基础战士', 'HERO', 'COMMON', 1, 50, 100, 10, 1, '基础战士卡牌'),
('精英法师', 'HERO', 'RARE', 2, 80, 80, 5, 2, '精英法师卡牌'),
('传说龙骑士', 'HERO', 'LEGENDARY', 3, 120, 150, 20, 3, '传说龙骑士卡牌');

INSERT INTO heroes (name, profession, race, rarity, level, base_attack, base_health, base_armor, cost, description) VALUES
('亚瑟王', 'WARRIOR', 'HUMAN', 'LEGENDARY', 1, 100, 200, 15, 3, '传说中的王者'),
('梅林', 'MAGE', 'HUMAN', 'EPIC', 1, 80, 120, 5, 2, '强大的法师'),
('精灵射手', 'ASSASSIN', 'ELF', 'RARE', 1, 60, 100, 8, 2, '敏捷的精灵射手');

INSERT INTO baseEquipments (name, type, rarity, level, attack_bonus, health_bonus, cost, description) VALUES
('铁剑', 'WEAPON', 'COMMON', 1, 20, 0, 1, '基础武器'),
('魔法法杖', 'WEAPON', 'RARE', 2, 40, 0, 2, '增强魔法攻击的法杖'),
('龙鳞护甲', 'ARMOR', 'LEGENDARY', 3, 0, 100, 3, '传说龙鳞制成的护甲');
