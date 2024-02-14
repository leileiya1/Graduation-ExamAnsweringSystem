/*
 Navicat Premium Data Transfer

 Source Server         : linux
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : 192.168.100.137:3306
 Source Schema         : graduation_design

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 14/02/2024 10:15:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions`  (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `options` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL,
  `answer` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `is_selected` tinyint NULL DEFAULT NULL,
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES (1, 'single_choice', '波特酒主要生产于哪个国家？', 'A. 法国,B. 意大利,C. 西班牙,D. 葡萄牙', '葡萄牙', 0);
INSERT INTO `questions` VALUES (2, 'single_choice', '以下哪种葡萄酒一般是甜的？', 'A. 霞多丽,B. 雷司令,C. 赤霞珠,D. 梅洛', '雷司令', 0);
INSERT INTO `questions` VALUES (3, 'multiple_choice', '在品酒过程中，通常会评估哪些方面？', 'A. 色泽,B. 香气,C. 口感,D. 声音', '色泽.香气.口感', 0);
INSERT INTO `questions` VALUES (4, 'multiple_choice', '以下哪些因素会影响葡萄酒的风味？', 'A. 葡萄种类,B. 土壤类型,C. 气候条件,D. 酒瓶形状', '葡萄种类.土壤类型.气候条件', 0);
INSERT INTO `questions` VALUES (5, 'fill_in_the_blank', '_________ 是用来描述一种葡萄酒的香气和口感，通常指含有石灰岩或矿物质味道的白葡萄酒。', NULL, '矿物感', 0);
INSERT INTO `questions` VALUES (6, 'fill_in_the_blank', '葡萄酒中的_________ 是由于酵母将葡萄汁中的糖分转化为酒精和二氧化碳而产生的。', NULL, '酒精', 0);
INSERT INTO `questions` VALUES (7, 'essay', '简述桶陈对葡萄酒口感的影响。', NULL, '桶陈可以增加葡萄酒的复杂性和深度，赋予其木质香、香草味或烤面包味。它还有助于软化葡萄酒中的单宁，使酒体更加圆润。', 0);
INSERT INTO `questions` VALUES (8, 'essay', '解释‘酒体’是如何在品酒时被评价的。', NULL, '酒体是指葡萄酒的重量感和口感强度。它可以根据葡萄酒的厚重度、酒精含量、单宁和糖分来评估，分为轻盈、中等和醇厚等级别。', 0);
INSERT INTO `questions` VALUES (11, 'single_choice', '下列哪种酒通常用于烹饪？', 'A. 波特酒,B. 香槟,C. 马赛拉酒,D. 冰酒', '马赛拉酒', 0);
INSERT INTO `questions` VALUES (12, 'single_choice', '下列哪种酒是由稻米酿造的？', 'A. 白兰地,B. 清酒,C. 朗姆酒,D. 伏特加', '清酒', 0);
INSERT INTO `questions` VALUES (13, 'multiple_choice', '葡萄酒的哪些特性可以通过品鉴得出？', 'A. 年份,B. 产地,C. 葡萄品种,D. 储存方式', '年份.产地.葡萄品种', 0);
INSERT INTO `questions` VALUES (14, 'multiple_choice', '下列哪些因素对葡萄酒的品质有显著影响？', 'A. 阳光照射,B. 发酵容器,C. 葡萄的成熟度,D. 酒标设计', '阳光照射.发酵容器.葡萄的成熟度', 0);
INSERT INTO `questions` VALUES (15, 'fill_in_the_blank', '在葡萄酒术语中，_________ 指的是葡萄酒的味道在口中停留的时间。', NULL, '余味 或 尾韵', 0);
INSERT INTO `questions` VALUES (16, 'fill_in_the_blank', '_________ 是一种法国红葡萄酒，以其深色和丰富的单宁而闻名。', NULL, '梅洛', 0);
INSERT INTO `questions` VALUES (17, 'essay', '描述香槟的基本制作过程。', NULL, '香槟的制作过程包括初次发酵、混合、瓶内二次发酵、陈年、冷冻与除渣、加入剂量酒，最后密封瓶塞。', 0);
INSERT INTO `questions` VALUES (18, 'essay', '解释‘葡萄酒单宁’的来源和作用。', NULL, '葡萄酒中的单宁主要来源于葡萄皮、籽和橡木桶。它为葡萄酒提供结构，赋予苦涩感，有助于葡萄酒的陈年潜力。', 0);
INSERT INTO `questions` VALUES (19, 'true_false', '所有的葡萄酒都可以通过陈年来提升其风味。', NULL, 'False', 0);
INSERT INTO `questions` VALUES (20, 'true_false', '干型葡萄酒通常比甜型葡萄酒含有更低的残留糖分。', NULL, 'True', 0);
INSERT INTO `questions` VALUES (21, 'single_choice', '夏布利产区以生产哪种类型的葡萄酒而闻名？', 'A. 霞多丽,B. 赤霞珠,C. 默洛,D. 丽贝拉', '霞多丽', 0);
INSERT INTO `questions` VALUES (22, 'single_choice', '下列哪种葡萄酒通常是用黑皮诺（Pinot Noir）葡萄酿造的？', 'A. 红葡萄酒,B. 白葡萄酒,C. 玫瑰葡萄酒,D. 香槟', '香槟', 0);
INSERT INTO `questions` VALUES (24, 'single_choice', '意大利哪些产区以生产优质的普罗塞克（Prosecco）而知名？', 'A. 托斯卡纳,B. 皮埃蒙特,C. 威尼托,D. 西西里', '威尼托', 0);
INSERT INTO `questions` VALUES (25, 'fill_in_the_blank', '_________ 是一种在酒瓶中进行二次发酵的过程，通常用于生产某些类型的起泡酒。', NULL, '瓶内二次发酵', 0);
INSERT INTO `questions` VALUES (26, 'fill_in_the_blank', '_________ 是评价葡萄酒的三个基本标准之一，指的是葡萄酒在口中留存的时间长度。', NULL, '余味', 0);
INSERT INTO `questions` VALUES (27, 'essay', '解释什么是\'陈年潜力\'，以及为何某些葡萄酒比其他的更适合陈年。', NULL, '陈年潜力是指葡萄酒随时间发展而改善其风味和复杂度的能力。高单宁含量、酸度和糖分的葡萄酒通常具有更好的陈年潜力，因为这些成分随时间的演变有助于葡萄酒的风味成熟。', 0);
INSERT INTO `questions` VALUES (28, 'essay', '描述在葡萄酒生产中，不同类型的橡木桶如何影响葡萄酒的最终风味。', NULL, '不同的橡木桶可以赋予葡萄酒不同的风味特征。例如，美国橡木通常会带来更强烈的香草和焦糖味，而法国橡木则提供更为细腻和复杂的香气。桶的烤火程度也会影响葡萄酒的口感，更重的烤火带来更强的烤面包和烟熏味。', 0);
INSERT INTO `questions` VALUES (31, 'single_choice', '夏布利产区以生产哪种类型的葡萄酒而闻名？', 'A. 霞多丽,B. 赤霞珠,C. 默洛,D. 丽贝拉', '霞多丽', 0);
INSERT INTO `questions` VALUES (32, 'single_choice', '下列哪种葡萄酒通常是用黑皮诺（Pinot Noir）葡萄酿造的？', 'A. 红葡萄酒,B. 白葡萄酒,C. 玫瑰葡萄酒,D. 香槟', '香槟', 0);
INSERT INTO `questions` VALUES (33, 'multiple_choice', '在品鉴香槟时，通常会关注哪些方面？', 'A. 泡沫,B. 颜色,C. 香气,D. 酒精度', '泡沫.颜色.香气', 0);
INSERT INTO `questions` VALUES (35, 'fill_in_the_blank', '_________ 是一种常见的香槟类型，通常比较干，糖分含量低。', NULL, 'Brut', 0);
INSERT INTO `questions` VALUES (36, 'fill_in_the_blank', '_________ 是意大利著名的甜葡萄酒，通常用干葡萄制成。', NULL, '维诺圣徒', 0);
INSERT INTO `questions` VALUES (37, 'essay', '描述什么是冷稳技术，以及它在葡萄酒制作中的作用。', NULL, '冷稳是一种通过降低温度来稳定葡萄酒的过程。它有助于去除过量的酒石酸盐晶体，防止酒瓶内形成沉淀，从而保持酒液的清澈和稳定。', 0);
INSERT INTO `questions` VALUES (38, 'essay', '简述葡萄酒酿造中酒精发酵的基本原理。', NULL, '酒精发酵是指酵母将葡萄汁中的糖分转化为酒精和二氧化碳的过程。这个过程产生了葡萄酒的酒精含量，并且会影响其风味和口感。', 0);
INSERT INTO `questions` VALUES (39, 'single_choice', '在制作波尔多葡萄酒时，通常使用的主要葡萄品种是什么？', 'A. 赤霞珠,B. 默洛,C. 霞多丽,D. 佳美', '赤霞珠', 0);
INSERT INTO `questions` VALUES (40, 'single_choice', '通常情况下，香槟酒是由哪些葡萄品种混合酿造的？', 'A. 皮诺·格里吉奥和霞多丽,B. 黑皮诺和佳美,C. 黑皮诺、霞多丽和梅尼埃,D. 赤霞珠和桑娇维塞', '黑皮诺、霞多丽和梅尼埃', 0);
INSERT INTO `questions` VALUES (41, 'multiple_choice', '下列哪些特性通常用于描述葡萄酒的香气？', 'A. 水果,B. 花香,C. 草本,D. 矿物质', '水果.花香.草本.矿物质', 0);
INSERT INTO `questions` VALUES (42, 'multiple_choice', '葡萄酒的口感可以被哪些因素影响？', 'A. 酸度,B. 单宁,C. 甜度,D. 酒体', '酸度.单宁.甜度.酒体', 0);
INSERT INTO `questions` VALUES (43, 'fill_in_the_blank', '在葡萄酒制作过程中，_________ 是指将葡萄酒从一个容器转移到另一个容器，以分离沉淀物。', NULL, '渗流', 0);
INSERT INTO `questions` VALUES (44, 'fill_in_the_blank', '_________ 是一种法国干白葡萄酒，以其柑橘和矿物质的味道闻名。', NULL, '索维翁·布朗', 0);
INSERT INTO `questions` VALUES (45, 'essay', '描述桶陈对葡萄酒口感的影响。', NULL, '桶陈可以为葡萄酒增添多样的风味，如香草、焦糖和烤面包味，同时帮助软化单宁，使葡萄酒更圆润、口感更丰富。', 0);
INSERT INTO `questions` VALUES (46, 'essay', '简述葡萄酒陈年过程中颜色的变化。', NULL, '随着陈年，红葡萄酒的颜色会从鲜艳的红色逐渐变为砖红色，而白葡萄酒则会从淡黄色变为更深的金黄色。', 0);
INSERT INTO `questions` VALUES (47, 'single_choice', '通常情况下，下列哪种葡萄酒是在橡木桶中陈年？', 'A. 普罗塞克,B. 霞多丽,C. 皮诺·诺瓦尔,D. 波尔多', '霞多丽', 0);
INSERT INTO `questions` VALUES (48, 'single_choice', '波特酒是哪个国家的特产？', 'A. 法国,B. 意大利,C. 葡萄牙,D. 西班牙', '葡萄牙', 0);
INSERT INTO `questions` VALUES (49, 'multiple_choice', '哪些元素被认为是评价葡萄酒品质的关键因素？', 'A. 葡萄品种,B. 酒精含量,C. 产地,D. 香气', '葡萄品种.产地.香气', 0);
INSERT INTO `questions` VALUES (50, 'multiple_choice', '在葡萄酒制作过程中，哪些步骤被认为至关重要？', 'A. 发酵,B. 搾汁,C. 过滤,D. 瓶装', '发酵.搾汁.过滤', 0);
INSERT INTO `questions` VALUES (51, 'fill_in_the_blank', '_________ 是指葡萄酒的色泽、香气和风味随着时间的演变而发生的变化。', NULL, '陈年', 0);
INSERT INTO `questions` VALUES (52, 'fill_in_the_blank', '_________ 是一种葡萄酒术语，用来描述葡萄酒中的果味和花香等风味特征。', NULL, '芳香复杂性', 0);
INSERT INTO `questions` VALUES (53, 'essay', '简述冰酒的特点和制作过程。', NULL, '冰酒是一种甜葡萄酒，由在自然冰冻条件下采摘的葡萄制成。这些葡萄在冰冻时被压榨，从而产生高糖分的汁液。冰酒的特点是浓郁的甜度和新鲜的酸度平衡。', 0);
INSERT INTO `questions` VALUES (54, 'essay', '解释‘酒精发酵’在葡萄酒制作中的作用。', NULL, '酒精发酵是葡萄酒制作的关键步骤，其中酵母转化葡萄汁中的糖分成酒精和二氧化碳。这个过程不仅产生了葡萄酒的酒精含量，也对葡萄酒的风味产生重要影响。', 0);
INSERT INTO `questions` VALUES (55, 'single_choice', '里奥哈葡萄酒主要以哪种葡萄品种酿造？', 'A. 霞多丽,B. 丹魄,C. 桑娇维塞,D. 佳美', '丹魄', 0);
INSERT INTO `questions` VALUES (56, 'single_choice', '通常情况下，葡萄酒中的酸度是由哪种物质主导的？', 'A. 酒精,B. 糖分,C. 酒石酸,D. 单宁', '酒石酸', 0);
INSERT INTO `questions` VALUES (57, 'multiple_choice', '哪些条件对葡萄酒的风味和品质有显著影响？', 'A. 季节变化,B. 葡萄品种,C. 酿酒师的技艺,D. 土壤类型', '葡萄品种.酿酒师的技艺.土壤类型', 0);
INSERT INTO `questions` VALUES (58, 'multiple_choice', '在品酒过程中，哪些方面被认为是评估葡萄酒的关键指标？', 'A. 色泽,B. 香气,C. 口感,D. 瓶装设计', '色泽.香气.口感', 0);
INSERT INTO `questions` VALUES (59, 'fill_in_the_blank', '_________ 是一种流行的葡萄酒评分系统，由葡萄酒评论家罗伯特·帕克创立。', NULL, '帕克分', 0);
INSERT INTO `questions` VALUES (60, 'fill_in_the_blank', '_________ 是一种葡萄酒术语，指葡萄酒中的果味和花香等风味特征。', NULL, '芳香复杂性', 0);
INSERT INTO `questions` VALUES (61, 'essay', '简述干邑（Cognac）和白兰地（Brandy）之间的主要区别。', NULL, '干邑是一种特定地区生产的白兰地，必须在法国干邑地区按照严格的规定生产。而白兰地则是一个更广泛的术语，指的是通过葡萄酒蒸馏而成的酒精饮料，可以在世界各地生产。', 0);
INSERT INTO `questions` VALUES (62, 'essay', '描述什么是橡木桶陈酿，以及它如何影响葡萄酒的风味。', NULL, '橡木桶陈酿是将葡萄酒存放在橡木桶中一段时间的过程。这样做可以让葡萄酒吸收桶中的香气，如香草、烟熏和焦糖等，同时桶中的单宁也会使葡萄酒变得更加圆润、口感更丰富。', 0);
INSERT INTO `questions` VALUES (63, 'single_choice', '下列哪种葡萄酒被称为\'夜之女王\'，是德国著名的甜白葡萄酒？', 'A. 冰酒,B. 雷司令,C. 格瓦茨特拉明,D. 霞多丽', '雷司令', 0);
INSERT INTO `questions` VALUES (64, 'single_choice', '马尔贝克是哪个国家特有的葡萄酒品种？', 'A. 意大利,B. 阿根廷,C. 智利,D. 南非', '阿根廷', 0);
INSERT INTO `questions` VALUES (65, 'multiple_choice', '以下哪些特征通常用于描述白葡萄酒？', 'A. 果香,B. 花香,C. 橡木味,D. 酒石酸', '果香.花香.酒石酸', 0);
INSERT INTO `questions` VALUES (66, 'multiple_choice', '在葡萄酒制作中，以下哪些步骤是常见的？', 'A. 破碎,B. 发酵,C. 过滤,D. 装瓶', '破碎.发酵.过滤.装瓶', 0);
INSERT INTO `questions` VALUES (67, 'fill_in_the_blank', '_________ 是一种著名的意大利起泡酒，与香槟类似，但使用不同的葡萄品种。', NULL, '阿斯蒂', 0);
INSERT INTO `questions` VALUES (68, 'fill_in_the_blank', '_________ 是用于描述葡萄酒中干草、土壤等气味的术语，常见于陈年葡萄酒。', NULL, '泥土香', 0);
INSERT INTO `questions` VALUES (69, 'essay', '解释为什么葡萄酒的储存温度很重要，以及理想的储存温度范围是多少。', NULL, '葡萄酒的储存温度对其品质保持非常重要，因为温度变化会影响葡萄酒的成熟速度和风味。理想的储存温度一般在12-14°C，可以保持葡萄酒的稳定性和慢慢成熟。', 0);
INSERT INTO `questions` VALUES (70, 'essay', '描述霞多丽葡萄酒的典型风味特征。', NULL, '霞多丽葡萄酒通常具有苹果、柑橘和熟梨的果香，搭配着香草和烤面包的橡木桶香气。它的口感通常丰富，带有明显的酸度和柔滑的口感。', 0);
INSERT INTO `questions` VALUES (71, 'single_choice', '在葡萄酒品鉴中，用于描述葡萄酒酸度和果味之间平衡的术语是什么？', 'A. 酒体,B. 结构,C. 平衡,D. 芳香', '平衡', 0);
INSERT INTO `questions` VALUES (72, 'single_choice', '通常情况下，下列哪种葡萄酒会在瓶中进行二次发酵？', 'A. 赤霞珠,B. 香槟,C. 马尔贝克,D. 索维翁·布朗', '香槟', 0);
INSERT INTO `questions` VALUES (73, 'multiple_choice', '葡萄酒的哪些因素可以通过视觉检查评估？', 'A. 色泽,B. 透明度,C. 粘稠度,D. 泡沫', '色泽.透明度.粘稠度', 0);
INSERT INTO `questions` VALUES (74, 'multiple_choice', '以下哪些方法被用于增加葡萄酒的复杂性和口感深度？', 'A. 橡木桶陈年,B. 冷温发酵,C. 瓶内陈年,D. 酵母接触', '橡木桶陈年.瓶内陈年.酵母接触', 0);
INSERT INTO `questions` VALUES (75, 'fill_in_the_blank', '_________ 是指葡萄酒在达到完美饮用状态之前的储存过程。', NULL, '陈年', 0);
INSERT INTO `questions` VALUES (76, 'fill_in_the_blank', '_________ 是一种以其独特的粉红色泽和浆果风味著名的葡萄酒。', NULL, '玫瑰葡萄酒', 0);
INSERT INTO `questions` VALUES (77, 'essay', '描述在葡萄酒品鉴中，\'口感\'这一术语包含哪些方面。', NULL, '口感涵盖葡萄酒的多个方面，包括酸度、甜度、单宁、酒体和余味。它描述了葡萄酒在口中的整体感觉，包括质地、重量和平衡。', 0);
INSERT INTO `questions` VALUES (78, 'essay', '解释什么是\'蒸馏酒\'，以及它与葡萄酒的主要区别。', NULL, '蒸馏酒是通过蒸馏发酵液体制成的酒精饮料，如伏特加、白兰地和威士忌。它与葡萄酒的主要区别在于制作过程和酒精含量。葡萄酒是通过发酵葡萄汁制成，而蒸馏酒则是通过蒸馏提高酒精浓度。', 0);
INSERT INTO `questions` VALUES (79, 'single_choice', '下列哪种葡萄酒通常以干型和半干型最为著名？', 'A. 雷司令,B. 霞多丽,C. 赤霞珠,D. 佳美', '雷司令', 0);
INSERT INTO `questions` VALUES (80, 'single_choice', '白兰地是通过蒸馏哪种饮料制成的？', 'A. 啤酒,B. 葡萄酒,C. 苹果汁,D. 米酒', '葡萄酒', 0);
INSERT INTO `questions` VALUES (81, 'multiple_choice', '在制作葡萄酒时，哪些步骤对于决定最终风味至关重要？', 'A. 葡萄的选择,B. 发酵过程,C. 瓶装,D. 陈年', '葡萄的选择.发酵过程.陈年', 0);
INSERT INTO `questions` VALUES (82, 'multiple_choice', '葡萄酒中哪些因素可以决定其甜度？', 'A. 葡萄的成熟度,B. 发酵时间,C. 添加的糖分,D. 酸度', '葡萄的成熟度.发酵时间.添加的糖分', 0);
INSERT INTO `questions` VALUES (83, 'fill_in_the_blank', '_________ 是指葡萄酒中的单宁和其他化合物随时间的演变而逐渐融合的过程。', NULL, '软化', 0);
INSERT INTO `questions` VALUES (84, 'fill_in_the_blank', '在葡萄酒的世界里，_________ 通常用来描述那些具有鲜明、浓烈果香的葡萄酒。', NULL, '果味浓郁', 0);
INSERT INTO `questions` VALUES (85, 'essay', '描述如何通过色泽来判断葡萄酒的年龄和类型。', NULL, '葡萄酒的色泽可以揭示其年龄和类型。年轻的红葡萄酒通常呈鲜艳的红色或紫色，而随着年龄增长，颜色转为砖红或棕色。年轻的白葡萄酒颜色较浅，而老白酒则变为深黄或琥珀色。', 0);
INSERT INTO `questions` VALUES (86, 'essay', '解释什么是残余糖分，以及它如何影响葡萄酒的风味。', NULL, '残余糖分是指发酵过程中未被转化为酒精的糖分。这些糖分赋予葡萄酒一定的甜度，影响其整体口感，从干型（低残余糖分）到甜型（高残余糖分）不等。', 0);
INSERT INTO `questions` VALUES (87, 'single_choice', '下列哪种葡萄酒通常以干型和半干型最为著名？', 'A. 雷司令,B. 霞多丽,C. 赤霞珠,D. 佳美', '雷司令', 0);
INSERT INTO `questions` VALUES (88, 'single_choice', '白兰地是通过蒸馏哪种饮料制成的？', 'A. 啤酒,B. 葡萄酒,C. 苹果汁,D. 米酒', '葡萄酒', 0);
INSERT INTO `questions` VALUES (89, 'multiple_choice', '在制作葡萄酒时，哪些步骤对于决定最终风味至关重要？', 'A. 葡萄的选择,B. 发酵过程,C. 瓶装,D. 陈年', '葡萄的选择.发酵过程.陈年', 0);
INSERT INTO `questions` VALUES (90, 'multiple_choice', '葡萄酒中哪些因素可以决定其甜度？', 'A. 葡萄的成熟度,B. 发酵时间,C. 添加的糖分,D. 酸度', '葡萄的成熟度.发酵时间.添加的糖分', 0);
INSERT INTO `questions` VALUES (91, 'fill_in_the_blank', '_________ 是指葡萄酒中的单宁和其他化合物随时间的演变而逐渐融合的过程。', NULL, '软化', 0);
INSERT INTO `questions` VALUES (92, 'fill_in_the_blank', '在葡萄酒的世界里，_________ 通常用来描述那些具有鲜明、浓烈果香的葡萄酒。', NULL, '果味浓郁', 0);
INSERT INTO `questions` VALUES (93, 'essay', '描述如何通过色泽来判断葡萄酒的年龄和类型。', NULL, '葡萄酒的色泽可以揭示其年龄和类型。年轻的红葡萄酒通常呈鲜艳的红色或紫色，而随着年龄增长，颜色转为砖红或棕色。年轻的白葡萄酒颜色较浅，而老白酒则变为深黄或琥珀色。', 0);
INSERT INTO `questions` VALUES (94, 'essay', '解释什么是残余糖分，以及它如何影响葡萄酒的风味。', NULL, '残余糖分是指发酵过程中未被转化为酒精的糖分。这些糖分赋予葡萄酒一定的甜度，影响其整体口感，从干型（低残余糖分）到甜型（高残余糖分）不等。', 0);

SET FOREIGN_KEY_CHECKS = 1;
