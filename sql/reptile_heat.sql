/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : reptile_heat

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 07/07/2022 17:40:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省名称',
  `city_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 459 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '中暑爬虫地区表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_area
-- ----------------------------
INSERT INTO `sys_area` VALUES (1, '全国', NULL);
INSERT INTO `sys_area` VALUES (2, '北京', '海淀');
INSERT INTO `sys_area` VALUES (3, '北京', '朝阳');
INSERT INTO `sys_area` VALUES (4, '北京', '顺义');
INSERT INTO `sys_area` VALUES (5, '北京', '怀柔');
INSERT INTO `sys_area` VALUES (6, '北京', '通州');
INSERT INTO `sys_area` VALUES (7, '北京', '昌平');
INSERT INTO `sys_area` VALUES (8, '北京', '延庆');
INSERT INTO `sys_area` VALUES (9, '北京', '丰台');
INSERT INTO `sys_area` VALUES (10, '北京', '石景山');
INSERT INTO `sys_area` VALUES (11, '北京', '大兴');
INSERT INTO `sys_area` VALUES (12, '北京', '房山');
INSERT INTO `sys_area` VALUES (13, '北京', '密云');
INSERT INTO `sys_area` VALUES (14, '北京', '门头沟');
INSERT INTO `sys_area` VALUES (15, '北京', '平谷');
INSERT INTO `sys_area` VALUES (16, '北京', '东城');
INSERT INTO `sys_area` VALUES (17, '北京', '西城');
INSERT INTO `sys_area` VALUES (18, '天津', '武清');
INSERT INTO `sys_area` VALUES (19, '天津', '宝坻');
INSERT INTO `sys_area` VALUES (20, '天津', '东丽');
INSERT INTO `sys_area` VALUES (21, '天津', '西青');
INSERT INTO `sys_area` VALUES (22, '天津', '北辰');
INSERT INTO `sys_area` VALUES (23, '天津', '宁河');
INSERT INTO `sys_area` VALUES (24, '天津', '和平');
INSERT INTO `sys_area` VALUES (25, '天津', '静海');
INSERT INTO `sys_area` VALUES (26, '天津', '津南');
INSERT INTO `sys_area` VALUES (27, '天津', '滨海新区');
INSERT INTO `sys_area` VALUES (28, '天津', '河东');
INSERT INTO `sys_area` VALUES (29, '天津', '河西');
INSERT INTO `sys_area` VALUES (30, '天津', '蓟州');
INSERT INTO `sys_area` VALUES (31, '天津', '南开');
INSERT INTO `sys_area` VALUES (32, '天津', '河北');
INSERT INTO `sys_area` VALUES (33, '天津', '红桥');
INSERT INTO `sys_area` VALUES (34, '河北', '石家庄');
INSERT INTO `sys_area` VALUES (35, '河北', '保定');
INSERT INTO `sys_area` VALUES (36, '河北', '张家口');
INSERT INTO `sys_area` VALUES (37, '河北', '承德');
INSERT INTO `sys_area` VALUES (38, '河北', '唐山');
INSERT INTO `sys_area` VALUES (39, '河北', '廊坊');
INSERT INTO `sys_area` VALUES (40, '河北', '沧州');
INSERT INTO `sys_area` VALUES (41, '河北', '衡水');
INSERT INTO `sys_area` VALUES (42, '河北', '邢台');
INSERT INTO `sys_area` VALUES (43, '河北', '邯郸');
INSERT INTO `sys_area` VALUES (44, '河北', '秦皇岛');
INSERT INTO `sys_area` VALUES (45, '河北', '雄安新区');
INSERT INTO `sys_area` VALUES (46, '山西', '太原');
INSERT INTO `sys_area` VALUES (47, '山西', '大同');
INSERT INTO `sys_area` VALUES (48, '山西', '阳泉');
INSERT INTO `sys_area` VALUES (49, '山西', '晋中');
INSERT INTO `sys_area` VALUES (50, '山西', '长治');
INSERT INTO `sys_area` VALUES (51, '山西', '晋城');
INSERT INTO `sys_area` VALUES (52, '山西', '临汾');
INSERT INTO `sys_area` VALUES (53, '山西', '运城');
INSERT INTO `sys_area` VALUES (54, '山西', '朔州');
INSERT INTO `sys_area` VALUES (55, '山西', '忻州');
INSERT INTO `sys_area` VALUES (56, '山西', '吕梁');
INSERT INTO `sys_area` VALUES (57, '内蒙古', '呼和浩特');
INSERT INTO `sys_area` VALUES (58, '内蒙古', '包头');
INSERT INTO `sys_area` VALUES (59, '内蒙古', '乌海');
INSERT INTO `sys_area` VALUES (60, '内蒙古', '乌兰察布');
INSERT INTO `sys_area` VALUES (61, '内蒙古', '通辽');
INSERT INTO `sys_area` VALUES (62, '内蒙古', '赤峰');
INSERT INTO `sys_area` VALUES (63, '内蒙古', '鄂尔多斯');
INSERT INTO `sys_area` VALUES (64, '内蒙古', '巴彦淖尔');
INSERT INTO `sys_area` VALUES (65, '内蒙古', '锡林郭勒');
INSERT INTO `sys_area` VALUES (66, '内蒙古', '呼伦贝尔');
INSERT INTO `sys_area` VALUES (67, '内蒙古', '兴安盟');
INSERT INTO `sys_area` VALUES (68, '内蒙古', '阿拉善盟');
INSERT INTO `sys_area` VALUES (69, '黑龙江', '哈尔滨');
INSERT INTO `sys_area` VALUES (70, '黑龙江', '齐齐哈尔');
INSERT INTO `sys_area` VALUES (71, '黑龙江', '牡丹江');
INSERT INTO `sys_area` VALUES (72, '黑龙江', '佳木斯');
INSERT INTO `sys_area` VALUES (73, '黑龙江', '绥化');
INSERT INTO `sys_area` VALUES (74, '黑龙江', '黑河');
INSERT INTO `sys_area` VALUES (75, '黑龙江', '大兴安岭');
INSERT INTO `sys_area` VALUES (76, '黑龙江', '伊春');
INSERT INTO `sys_area` VALUES (77, '黑龙江', '大庆');
INSERT INTO `sys_area` VALUES (78, '黑龙江', '七台河');
INSERT INTO `sys_area` VALUES (79, '黑龙江', '鸡西');
INSERT INTO `sys_area` VALUES (80, '黑龙江', '鹤岗');
INSERT INTO `sys_area` VALUES (81, '黑龙江', '双鸭山');
INSERT INTO `sys_area` VALUES (82, '吉林', '长春');
INSERT INTO `sys_area` VALUES (83, '吉林', '吉林');
INSERT INTO `sys_area` VALUES (84, '吉林', '延边');
INSERT INTO `sys_area` VALUES (85, '吉林', '四平');
INSERT INTO `sys_area` VALUES (86, '吉林', '通化');
INSERT INTO `sys_area` VALUES (87, '吉林', '白城');
INSERT INTO `sys_area` VALUES (88, '吉林', '辽源');
INSERT INTO `sys_area` VALUES (89, '吉林', '松原');
INSERT INTO `sys_area` VALUES (90, '吉林', '白山');
INSERT INTO `sys_area` VALUES (91, '辽宁', '沈阳');
INSERT INTO `sys_area` VALUES (92, '辽宁', '大连');
INSERT INTO `sys_area` VALUES (93, '辽宁', '鞍山');
INSERT INTO `sys_area` VALUES (94, '辽宁', '抚顺');
INSERT INTO `sys_area` VALUES (95, '辽宁', '本溪');
INSERT INTO `sys_area` VALUES (96, '辽宁', '丹东');
INSERT INTO `sys_area` VALUES (97, '辽宁', '锦州');
INSERT INTO `sys_area` VALUES (98, '辽宁', '营口');
INSERT INTO `sys_area` VALUES (99, '辽宁', '阜新');
INSERT INTO `sys_area` VALUES (100, '辽宁', '辽阳');
INSERT INTO `sys_area` VALUES (101, '辽宁', '铁岭');
INSERT INTO `sys_area` VALUES (102, '辽宁', '朝阳市');
INSERT INTO `sys_area` VALUES (103, '辽宁', '盘锦');
INSERT INTO `sys_area` VALUES (104, '辽宁', '葫芦岛');
INSERT INTO `sys_area` VALUES (105, '上海', '闵行');
INSERT INTO `sys_area` VALUES (106, '上海', '宝山');
INSERT INTO `sys_area` VALUES (107, '上海', '黄浦');
INSERT INTO `sys_area` VALUES (108, '上海', '嘉定');
INSERT INTO `sys_area` VALUES (109, '上海', '浦东新区');
INSERT INTO `sys_area` VALUES (110, '上海', '金山');
INSERT INTO `sys_area` VALUES (111, '上海', '青浦');
INSERT INTO `sys_area` VALUES (112, '上海', '松江');
INSERT INTO `sys_area` VALUES (113, '上海', '奉贤');
INSERT INTO `sys_area` VALUES (114, '上海', '崇明');
INSERT INTO `sys_area` VALUES (115, '上海', '徐汇');
INSERT INTO `sys_area` VALUES (116, '上海', '长宁');
INSERT INTO `sys_area` VALUES (117, '上海', '静安');
INSERT INTO `sys_area` VALUES (118, '上海', '普陀');
INSERT INTO `sys_area` VALUES (119, '上海', '虹口');
INSERT INTO `sys_area` VALUES (120, '上海', '杨浦');
INSERT INTO `sys_area` VALUES (121, '安徽', '合肥');
INSERT INTO `sys_area` VALUES (122, '安徽', '蚌埠');
INSERT INTO `sys_area` VALUES (123, '安徽', '芜湖');
INSERT INTO `sys_area` VALUES (124, '安徽', '淮南');
INSERT INTO `sys_area` VALUES (125, '安徽', '马鞍山');
INSERT INTO `sys_area` VALUES (126, '安徽', '安庆');
INSERT INTO `sys_area` VALUES (127, '安徽', '宿州');
INSERT INTO `sys_area` VALUES (128, '安徽', '阜阳');
INSERT INTO `sys_area` VALUES (129, '安徽', '亳州');
INSERT INTO `sys_area` VALUES (130, '安徽', '黄山');
INSERT INTO `sys_area` VALUES (131, '安徽', '滁州');
INSERT INTO `sys_area` VALUES (132, '安徽', '淮北');
INSERT INTO `sys_area` VALUES (133, '安徽', '铜陵');
INSERT INTO `sys_area` VALUES (134, '安徽', '宣城');
INSERT INTO `sys_area` VALUES (135, '安徽', '六安');
INSERT INTO `sys_area` VALUES (136, '安徽', '池州');
INSERT INTO `sys_area` VALUES (137, '江苏', '南京');
INSERT INTO `sys_area` VALUES (138, '江苏', '无锡');
INSERT INTO `sys_area` VALUES (139, '江苏', '镇江');
INSERT INTO `sys_area` VALUES (140, '江苏', '苏州');
INSERT INTO `sys_area` VALUES (141, '江苏', '南通');
INSERT INTO `sys_area` VALUES (142, '江苏', '扬州');
INSERT INTO `sys_area` VALUES (143, '江苏', '盐城');
INSERT INTO `sys_area` VALUES (144, '江苏', '徐州');
INSERT INTO `sys_area` VALUES (145, '江苏', '淮安');
INSERT INTO `sys_area` VALUES (146, '江苏', '连云港');
INSERT INTO `sys_area` VALUES (147, '江苏', '常州');
INSERT INTO `sys_area` VALUES (148, '江苏', '泰州');
INSERT INTO `sys_area` VALUES (149, '江苏', '宿迁');
INSERT INTO `sys_area` VALUES (150, '山东', '济南');
INSERT INTO `sys_area` VALUES (151, '山东', '青岛');
INSERT INTO `sys_area` VALUES (152, '山东', '淄博');
INSERT INTO `sys_area` VALUES (153, '山东', '德州');
INSERT INTO `sys_area` VALUES (154, '山东', '烟台');
INSERT INTO `sys_area` VALUES (155, '山东', '潍坊');
INSERT INTO `sys_area` VALUES (156, '山东', '济宁');
INSERT INTO `sys_area` VALUES (157, '山东', '泰安');
INSERT INTO `sys_area` VALUES (158, '山东', '临沂');
INSERT INTO `sys_area` VALUES (159, '山东', '菏泽');
INSERT INTO `sys_area` VALUES (160, '山东', '滨州');
INSERT INTO `sys_area` VALUES (161, '山东', '东营');
INSERT INTO `sys_area` VALUES (162, '山东', '威海');
INSERT INTO `sys_area` VALUES (163, '山东', '枣庄');
INSERT INTO `sys_area` VALUES (164, '山东', '日照');
INSERT INTO `sys_area` VALUES (165, '山东', '莱芜');
INSERT INTO `sys_area` VALUES (166, '山东', '聊城');
INSERT INTO `sys_area` VALUES (167, '浙江', '杭州');
INSERT INTO `sys_area` VALUES (168, '浙江', '湖州');
INSERT INTO `sys_area` VALUES (169, '浙江', '嘉兴');
INSERT INTO `sys_area` VALUES (170, '浙江', '宁波');
INSERT INTO `sys_area` VALUES (171, '浙江', '绍兴');
INSERT INTO `sys_area` VALUES (172, '浙江', '台州');
INSERT INTO `sys_area` VALUES (173, '浙江', '温州');
INSERT INTO `sys_area` VALUES (174, '浙江', '丽水');
INSERT INTO `sys_area` VALUES (175, '浙江', '金华');
INSERT INTO `sys_area` VALUES (176, '浙江', '衢州');
INSERT INTO `sys_area` VALUES (177, '浙江', '舟山');
INSERT INTO `sys_area` VALUES (178, '福建', '福州');
INSERT INTO `sys_area` VALUES (179, '福建', '厦门');
INSERT INTO `sys_area` VALUES (180, '福建', '宁德');
INSERT INTO `sys_area` VALUES (181, '福建', '莆田');
INSERT INTO `sys_area` VALUES (182, '福建', '泉州');
INSERT INTO `sys_area` VALUES (183, '福建', '漳州');
INSERT INTO `sys_area` VALUES (184, '福建', '龙岩');
INSERT INTO `sys_area` VALUES (185, '福建', '三明');
INSERT INTO `sys_area` VALUES (186, '福建', '南平');
INSERT INTO `sys_area` VALUES (187, '福建', '钓鱼岛');
INSERT INTO `sys_area` VALUES (188, '江西', '南昌');
INSERT INTO `sys_area` VALUES (189, '江西', '九江');
INSERT INTO `sys_area` VALUES (190, '江西', '上饶');
INSERT INTO `sys_area` VALUES (191, '江西', '抚州');
INSERT INTO `sys_area` VALUES (192, '江西', '宜春');
INSERT INTO `sys_area` VALUES (193, '江西', '吉安');
INSERT INTO `sys_area` VALUES (194, '江西', '赣州');
INSERT INTO `sys_area` VALUES (195, '江西', '景德镇');
INSERT INTO `sys_area` VALUES (196, '江西', '萍乡');
INSERT INTO `sys_area` VALUES (197, '江西', '新余');
INSERT INTO `sys_area` VALUES (198, '江西', '鹰潭');
INSERT INTO `sys_area` VALUES (199, '湖北', '武汉');
INSERT INTO `sys_area` VALUES (200, '湖北', '襄阳');
INSERT INTO `sys_area` VALUES (201, '湖北', '鄂州');
INSERT INTO `sys_area` VALUES (202, '湖北', '孝感');
INSERT INTO `sys_area` VALUES (203, '湖北', '黄冈');
INSERT INTO `sys_area` VALUES (204, '湖北', '黄石');
INSERT INTO `sys_area` VALUES (205, '湖北', '咸宁');
INSERT INTO `sys_area` VALUES (206, '湖北', '荆州');
INSERT INTO `sys_area` VALUES (207, '湖北', '宜昌');
INSERT INTO `sys_area` VALUES (208, '湖北', '恩施');
INSERT INTO `sys_area` VALUES (209, '湖北', '十堰');
INSERT INTO `sys_area` VALUES (210, '湖北', '神农架');
INSERT INTO `sys_area` VALUES (211, '湖北', '随州');
INSERT INTO `sys_area` VALUES (212, '湖北', '荆门');
INSERT INTO `sys_area` VALUES (213, '湖北', '天门');
INSERT INTO `sys_area` VALUES (214, '湖北', '仙桃');
INSERT INTO `sys_area` VALUES (215, '湖北', '潜江');
INSERT INTO `sys_area` VALUES (216, '湖南', '长沙');
INSERT INTO `sys_area` VALUES (217, '湖南', '湘潭');
INSERT INTO `sys_area` VALUES (218, '湖南', '株洲');
INSERT INTO `sys_area` VALUES (219, '湖南', '衡阳');
INSERT INTO `sys_area` VALUES (220, '湖南', '郴州');
INSERT INTO `sys_area` VALUES (221, '湖南', '常德');
INSERT INTO `sys_area` VALUES (222, '湖南', '益阳');
INSERT INTO `sys_area` VALUES (223, '湖南', '娄底');
INSERT INTO `sys_area` VALUES (224, '湖南', '邵阳');
INSERT INTO `sys_area` VALUES (225, '湖南', '岳阳');
INSERT INTO `sys_area` VALUES (226, '湖南', '张家界');
INSERT INTO `sys_area` VALUES (227, '湖南', '怀化');
INSERT INTO `sys_area` VALUES (228, '湖南', '永州');
INSERT INTO `sys_area` VALUES (229, '湖南', '湘西');
INSERT INTO `sys_area` VALUES (230, '河南', '郑州');
INSERT INTO `sys_area` VALUES (231, '河南', '安阳');
INSERT INTO `sys_area` VALUES (232, '河南', '新乡');
INSERT INTO `sys_area` VALUES (233, '河南', '许昌');
INSERT INTO `sys_area` VALUES (234, '河南', '平顶山');
INSERT INTO `sys_area` VALUES (235, '河南', '信阳');
INSERT INTO `sys_area` VALUES (236, '河南', '南阳');
INSERT INTO `sys_area` VALUES (237, '河南', '开封');
INSERT INTO `sys_area` VALUES (238, '河南', '洛阳');
INSERT INTO `sys_area` VALUES (239, '河南', '商丘');
INSERT INTO `sys_area` VALUES (240, '河南', '焦作');
INSERT INTO `sys_area` VALUES (241, '河南', '鹤壁');
INSERT INTO `sys_area` VALUES (242, '河南', '濮阳');
INSERT INTO `sys_area` VALUES (243, '河南', '周口');
INSERT INTO `sys_area` VALUES (244, '河南', '漯河');
INSERT INTO `sys_area` VALUES (245, '河南', '驻马店');
INSERT INTO `sys_area` VALUES (246, '河南', '三门峡');
INSERT INTO `sys_area` VALUES (247, '河南', '济源');
INSERT INTO `sys_area` VALUES (248, '广西', '南宁');
INSERT INTO `sys_area` VALUES (249, '广西', '崇左');
INSERT INTO `sys_area` VALUES (250, '广西', '柳州');
INSERT INTO `sys_area` VALUES (251, '广西', '来宾');
INSERT INTO `sys_area` VALUES (252, '广西', '桂林');
INSERT INTO `sys_area` VALUES (253, '广西', '梧州');
INSERT INTO `sys_area` VALUES (254, '广西', '贺州');
INSERT INTO `sys_area` VALUES (255, '广西', '贵港');
INSERT INTO `sys_area` VALUES (256, '广西', '玉林');
INSERT INTO `sys_area` VALUES (257, '广西', '百色');
INSERT INTO `sys_area` VALUES (258, '广西', '钦州');
INSERT INTO `sys_area` VALUES (259, '广西', '河池');
INSERT INTO `sys_area` VALUES (260, '广西', '北海');
INSERT INTO `sys_area` VALUES (261, '广西', '防城港');
INSERT INTO `sys_area` VALUES (262, '广东', '广州');
INSERT INTO `sys_area` VALUES (263, '广东', '韶关');
INSERT INTO `sys_area` VALUES (264, '广东', '惠州');
INSERT INTO `sys_area` VALUES (265, '广东', '梅州');
INSERT INTO `sys_area` VALUES (266, '广东', '汕头');
INSERT INTO `sys_area` VALUES (267, '广东', '深圳');
INSERT INTO `sys_area` VALUES (268, '广东', '珠海');
INSERT INTO `sys_area` VALUES (269, '广东', '佛山');
INSERT INTO `sys_area` VALUES (270, '广东', '肇庆');
INSERT INTO `sys_area` VALUES (271, '广东', '湛江');
INSERT INTO `sys_area` VALUES (272, '广东', '江门');
INSERT INTO `sys_area` VALUES (273, '广东', '河源');
INSERT INTO `sys_area` VALUES (274, '广东', '清远');
INSERT INTO `sys_area` VALUES (275, '广东', '云浮');
INSERT INTO `sys_area` VALUES (276, '广东', '潮州');
INSERT INTO `sys_area` VALUES (277, '广东', '东莞');
INSERT INTO `sys_area` VALUES (278, '广东', '中山');
INSERT INTO `sys_area` VALUES (279, '广东', '阳江');
INSERT INTO `sys_area` VALUES (280, '广东', '揭阳');
INSERT INTO `sys_area` VALUES (281, '广东', '茂名');
INSERT INTO `sys_area` VALUES (282, '广东', '汕尾');
INSERT INTO `sys_area` VALUES (283, '海南', '海口');
INSERT INTO `sys_area` VALUES (284, '海南', '三亚');
INSERT INTO `sys_area` VALUES (285, '海南', '东方');
INSERT INTO `sys_area` VALUES (286, '海南', '临高');
INSERT INTO `sys_area` VALUES (287, '海南', '澄迈');
INSERT INTO `sys_area` VALUES (288, '海南', '儋州');
INSERT INTO `sys_area` VALUES (289, '海南', '昌江');
INSERT INTO `sys_area` VALUES (290, '海南', '白沙');
INSERT INTO `sys_area` VALUES (291, '海南', '琼中');
INSERT INTO `sys_area` VALUES (292, '海南', '定安');
INSERT INTO `sys_area` VALUES (293, '海南', '屯昌');
INSERT INTO `sys_area` VALUES (294, '海南', '琼海');
INSERT INTO `sys_area` VALUES (295, '海南', '文昌');
INSERT INTO `sys_area` VALUES (296, '海南', '保亭');
INSERT INTO `sys_area` VALUES (297, '海南', '万宁');
INSERT INTO `sys_area` VALUES (298, '海南', '陵水');
INSERT INTO `sys_area` VALUES (299, '海南', '乐东');
INSERT INTO `sys_area` VALUES (300, '海南', '五指山');
INSERT INTO `sys_area` VALUES (301, '海南', '西沙');
INSERT INTO `sys_area` VALUES (302, '海南', '中沙');
INSERT INTO `sys_area` VALUES (303, '海南', '南沙');
INSERT INTO `sys_area` VALUES (304, '陕西', '西安');
INSERT INTO `sys_area` VALUES (305, '陕西', '咸阳');
INSERT INTO `sys_area` VALUES (306, '陕西', '延安');
INSERT INTO `sys_area` VALUES (307, '陕西', '榆林');
INSERT INTO `sys_area` VALUES (308, '陕西', '渭南');
INSERT INTO `sys_area` VALUES (309, '陕西', '商洛');
INSERT INTO `sys_area` VALUES (310, '陕西', '安康');
INSERT INTO `sys_area` VALUES (311, '陕西', '汉中');
INSERT INTO `sys_area` VALUES (312, '陕西', '宝鸡');
INSERT INTO `sys_area` VALUES (313, '陕西', '铜川');
INSERT INTO `sys_area` VALUES (314, '陕西', '杨凌');
INSERT INTO `sys_area` VALUES (315, '甘肃', '兰州');
INSERT INTO `sys_area` VALUES (316, '甘肃', '定西');
INSERT INTO `sys_area` VALUES (317, '甘肃', '平凉');
INSERT INTO `sys_area` VALUES (318, '甘肃', '庆阳');
INSERT INTO `sys_area` VALUES (319, '甘肃', '武威');
INSERT INTO `sys_area` VALUES (320, '甘肃', '金昌');
INSERT INTO `sys_area` VALUES (321, '甘肃', '张掖');
INSERT INTO `sys_area` VALUES (322, '甘肃', '酒泉');
INSERT INTO `sys_area` VALUES (323, '甘肃', '天水');
INSERT INTO `sys_area` VALUES (324, '甘肃', '陇南');
INSERT INTO `sys_area` VALUES (325, '甘肃', '临夏');
INSERT INTO `sys_area` VALUES (326, '甘肃', '甘南');
INSERT INTO `sys_area` VALUES (327, '甘肃', '白银');
INSERT INTO `sys_area` VALUES (328, '甘肃', '嘉峪关');
INSERT INTO `sys_area` VALUES (329, '新疆', '乌鲁木齐');
INSERT INTO `sys_area` VALUES (330, '新疆', '克拉玛依');
INSERT INTO `sys_area` VALUES (331, '新疆', '石河子');
INSERT INTO `sys_area` VALUES (332, '新疆', '昌吉');
INSERT INTO `sys_area` VALUES (333, '新疆', '吐鲁番');
INSERT INTO `sys_area` VALUES (334, '新疆', '巴音郭楞');
INSERT INTO `sys_area` VALUES (335, '新疆', '阿拉尔');
INSERT INTO `sys_area` VALUES (336, '新疆', '阿克苏');
INSERT INTO `sys_area` VALUES (337, '新疆', '喀什');
INSERT INTO `sys_area` VALUES (338, '新疆', '伊犁');
INSERT INTO `sys_area` VALUES (339, '新疆', '塔城');
INSERT INTO `sys_area` VALUES (340, '新疆', '哈密');
INSERT INTO `sys_area` VALUES (341, '新疆', '和田');
INSERT INTO `sys_area` VALUES (342, '新疆', '阿勒泰');
INSERT INTO `sys_area` VALUES (343, '新疆', '克州');
INSERT INTO `sys_area` VALUES (344, '新疆', '博尔塔拉');
INSERT INTO `sys_area` VALUES (345, '新疆', '图木舒克');
INSERT INTO `sys_area` VALUES (346, '新疆', '五家渠');
INSERT INTO `sys_area` VALUES (347, '新疆', '铁门关');
INSERT INTO `sys_area` VALUES (348, '新疆', '北屯');
INSERT INTO `sys_area` VALUES (349, '新疆', '双河');
INSERT INTO `sys_area` VALUES (350, '新疆', '可克达拉');
INSERT INTO `sys_area` VALUES (351, '青海', '西宁');
INSERT INTO `sys_area` VALUES (352, '青海', '海东');
INSERT INTO `sys_area` VALUES (353, '青海', '黄南');
INSERT INTO `sys_area` VALUES (354, '青海', '海南');
INSERT INTO `sys_area` VALUES (355, '青海', '果洛');
INSERT INTO `sys_area` VALUES (356, '青海', '玉树');
INSERT INTO `sys_area` VALUES (357, '青海', '海西');
INSERT INTO `sys_area` VALUES (358, '青海', '海北');
INSERT INTO `sys_area` VALUES (359, '宁夏', '银川');
INSERT INTO `sys_area` VALUES (360, '宁夏', '石嘴山');
INSERT INTO `sys_area` VALUES (361, '宁夏', '吴忠');
INSERT INTO `sys_area` VALUES (362, '宁夏', '固原');
INSERT INTO `sys_area` VALUES (363, '宁夏', '中卫');
INSERT INTO `sys_area` VALUES (364, '四川', '成都');
INSERT INTO `sys_area` VALUES (365, '四川', '攀枝花');
INSERT INTO `sys_area` VALUES (366, '四川', '自贡');
INSERT INTO `sys_area` VALUES (367, '四川', '绵阳');
INSERT INTO `sys_area` VALUES (368, '四川', '南充');
INSERT INTO `sys_area` VALUES (369, '四川', '达州');
INSERT INTO `sys_area` VALUES (370, '四川', '遂宁');
INSERT INTO `sys_area` VALUES (371, '四川', '广安');
INSERT INTO `sys_area` VALUES (372, '四川', '巴中');
INSERT INTO `sys_area` VALUES (373, '四川', '泸州');
INSERT INTO `sys_area` VALUES (374, '四川', '宜宾');
INSERT INTO `sys_area` VALUES (375, '四川', '内江');
INSERT INTO `sys_area` VALUES (376, '四川', '资阳');
INSERT INTO `sys_area` VALUES (377, '四川', '乐山');
INSERT INTO `sys_area` VALUES (378, '四川', '眉山');
INSERT INTO `sys_area` VALUES (379, '四川', '凉山');
INSERT INTO `sys_area` VALUES (380, '四川', '雅安');
INSERT INTO `sys_area` VALUES (381, '四川', '甘孜');
INSERT INTO `sys_area` VALUES (382, '四川', '阿坝');
INSERT INTO `sys_area` VALUES (383, '四川', '德阳');
INSERT INTO `sys_area` VALUES (384, '四川', '广元');
INSERT INTO `sys_area` VALUES (385, '重庆', '永川');
INSERT INTO `sys_area` VALUES (386, '重庆', '合川');
INSERT INTO `sys_area` VALUES (387, '重庆', '南川');
INSERT INTO `sys_area` VALUES (388, '重庆', '江津');
INSERT INTO `sys_area` VALUES (389, '重庆', '渝北');
INSERT INTO `sys_area` VALUES (390, '重庆', '北碚');
INSERT INTO `sys_area` VALUES (391, '重庆', '巴南');
INSERT INTO `sys_area` VALUES (392, '重庆', '长寿');
INSERT INTO `sys_area` VALUES (393, '重庆', '黔江');
INSERT INTO `sys_area` VALUES (394, '重庆', '渝中');
INSERT INTO `sys_area` VALUES (395, '重庆', '万州');
INSERT INTO `sys_area` VALUES (396, '重庆', '涪陵');
INSERT INTO `sys_area` VALUES (397, '重庆', '城口');
INSERT INTO `sys_area` VALUES (398, '重庆', '云阳');
INSERT INTO `sys_area` VALUES (399, '重庆', '巫溪');
INSERT INTO `sys_area` VALUES (400, '重庆', '奉节');
INSERT INTO `sys_area` VALUES (401, '重庆', '巫山');
INSERT INTO `sys_area` VALUES (402, '重庆', '潼南');
INSERT INTO `sys_area` VALUES (403, '重庆', '垫江');
INSERT INTO `sys_area` VALUES (404, '重庆', '梁平');
INSERT INTO `sys_area` VALUES (405, '重庆', '忠县');
INSERT INTO `sys_area` VALUES (406, '重庆', '石柱');
INSERT INTO `sys_area` VALUES (407, '重庆', '大足');
INSERT INTO `sys_area` VALUES (408, '重庆', '荣昌');
INSERT INTO `sys_area` VALUES (409, '重庆', '铜梁');
INSERT INTO `sys_area` VALUES (410, '重庆', '璧山');
INSERT INTO `sys_area` VALUES (411, '重庆', '丰都');
INSERT INTO `sys_area` VALUES (412, '重庆', '武隆');
INSERT INTO `sys_area` VALUES (413, '重庆', '彭水');
INSERT INTO `sys_area` VALUES (414, '重庆', '綦江');
INSERT INTO `sys_area` VALUES (415, '重庆', '酉阳');
INSERT INTO `sys_area` VALUES (416, '重庆', '大渡口');
INSERT INTO `sys_area` VALUES (417, '重庆', '秀山');
INSERT INTO `sys_area` VALUES (418, '重庆', '江北');
INSERT INTO `sys_area` VALUES (419, '重庆', '沙坪坝');
INSERT INTO `sys_area` VALUES (420, '重庆', '九龙坡');
INSERT INTO `sys_area` VALUES (421, '重庆', '南岸');
INSERT INTO `sys_area` VALUES (422, '重庆', '开州');
INSERT INTO `sys_area` VALUES (423, '贵州', '贵阳');
INSERT INTO `sys_area` VALUES (424, '贵州', '遵义');
INSERT INTO `sys_area` VALUES (425, '贵州', '安顺');
INSERT INTO `sys_area` VALUES (426, '贵州', '黔南');
INSERT INTO `sys_area` VALUES (427, '贵州', '黔东南');
INSERT INTO `sys_area` VALUES (428, '贵州', '铜仁');
INSERT INTO `sys_area` VALUES (429, '贵州', '毕节');
INSERT INTO `sys_area` VALUES (430, '贵州', '六盘水');
INSERT INTO `sys_area` VALUES (431, '贵州', '黔西南');
INSERT INTO `sys_area` VALUES (432, '云南', '昆明');
INSERT INTO `sys_area` VALUES (433, '云南', '大理');
INSERT INTO `sys_area` VALUES (434, '云南', '红河');
INSERT INTO `sys_area` VALUES (435, '云南', '曲靖');
INSERT INTO `sys_area` VALUES (436, '云南', '保山');
INSERT INTO `sys_area` VALUES (437, '云南', '文山');
INSERT INTO `sys_area` VALUES (438, '云南', '玉溪');
INSERT INTO `sys_area` VALUES (439, '云南', '楚雄');
INSERT INTO `sys_area` VALUES (440, '云南', '普洱');
INSERT INTO `sys_area` VALUES (441, '云南', '昭通');
INSERT INTO `sys_area` VALUES (442, '云南', '临沧');
INSERT INTO `sys_area` VALUES (443, '云南', '怒江');
INSERT INTO `sys_area` VALUES (444, '云南', '迪庆');
INSERT INTO `sys_area` VALUES (445, '云南', '丽江');
INSERT INTO `sys_area` VALUES (446, '云南', '德宏');
INSERT INTO `sys_area` VALUES (447, '云南', '西双版纳');
INSERT INTO `sys_area` VALUES (448, '西藏', '拉萨');
INSERT INTO `sys_area` VALUES (449, '西藏', '日喀则');
INSERT INTO `sys_area` VALUES (450, '西藏', '山南');
INSERT INTO `sys_area` VALUES (451, '西藏', '林芝');
INSERT INTO `sys_area` VALUES (452, '西藏', '昌都');
INSERT INTO `sys_area` VALUES (453, '西藏', '那曲');
INSERT INTO `sys_area` VALUES (454, '西藏', '阿里');
INSERT INTO `sys_area` VALUES (455, '香港', '香港');
INSERT INTO `sys_area` VALUES (456, '澳门', '澳门');
INSERT INTO `sys_area` VALUES (457, '台湾', '台北');
INSERT INTO `sys_area` VALUES (458, '台湾', '高雄');
INSERT INTO `sys_area` VALUES (459, '台湾', '台中');

-- ----------------------------
-- Table structure for tbl_city_temperature_7days
-- ----------------------------
DROP TABLE IF EXISTS `tbl_city_temperature_7days`;
CREATE TABLE `tbl_city_temperature_7days`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `cur_time` datetime(0) NULL DEFAULT NULL COMMENT '当前日期',
  `maximum_temp` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高温度',
  `minimum_temp` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最低温度',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '插入日期',
  `province_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3591 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '7天温度记录表, 只存7天数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_city_temperature_7days
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_city_temperature_day
-- ----------------------------
DROP TABLE IF EXISTS `tbl_city_temperature_day`;
CREATE TABLE `tbl_city_temperature_day`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `maximum_temp` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高温度',
  `minimum_temp` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最低温度',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '插入日期',
  `province_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3596 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '按城市划分每日温度- 用于年度统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_city_temperature_day
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_user`;
CREATE TABLE `tbl_sys_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '递增ID',
  `user_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编码',
  `user_password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `user_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户类型',
  `stop_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '停用标识（0：正常；1：停用）',
  `user_detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户描述',
  `end_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录日期',
  `opt_user` int(11) NULL DEFAULT NULL COMMENT '操作者',
  `opt_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '操作时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `un_tsu_uc`(`user_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_sys_user
-- ----------------------------
INSERT INTO `tbl_sys_user` VALUES (1, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', '管理员', '5', 0, '系统管理', '2022-07-07 17:33:33', 1, '2019-11-19 11:30:07');

SET FOREIGN_KEY_CHECKS = 1;
