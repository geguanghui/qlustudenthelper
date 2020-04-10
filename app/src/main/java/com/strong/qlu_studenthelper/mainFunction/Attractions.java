package com.strong.qlu_studenthelper.mainFunction;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.strong.qlu_studenthelper.R;
import com.strong.qlu_studenthelper.attractions.Scenic;
import com.strong.qlu_studenthelper.attractions.ScenicAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Attractions extends AppCompatActivity {

    private DrawerLayout drawerLayout ;

    private Scenic[] scenics = {
            new Scenic(R.drawable.zhulou,"主楼","黑龙江大学主楼建筑风格为折衷式，融合了俄罗斯社会主义民族风格的基本框架和中国建筑的装饰，是哈尔滨近现代建筑中的代表。黑龙江大学主楼，与哈尔滨工业大学主楼、黑龙江中医院大学主楼 被国家文化部誉为全国高校“俄罗斯社会主义民族风格”教学主楼三大经典作品，是国家级一类保护建筑（全国重点文物保护工程）。"),
            new Scenic(R.drawable.zhulou,"中俄学院(2018)","中俄学院于2011年6月正式成立，是黑龙江大学与新西伯利亚国立大学按照国际一流学院发展理念与模式联合建立的新型学院。中俄学院在全国首创“专业+俄语”人才培养模式，以培养服务“一带一路”国家战略和中俄全面战略协作伙伴关系的国际化、复合型、应用性人才为目标，依托黑龙江大学和新西伯利亚国立大学的优质办学资源，着力培养精通俄语、掌握自然学科和人文学科专业知识、熟知俄罗斯国情、具有国际化视野和对俄综合专业实践能力的高级专门人才。目前，中俄学院共设有化学工程与工艺、应用物理学、生物技术、数学与应用数学、金融学和法学等6个本科专业。中俄联合研究生学院开设有化学、光学、生物学、数学、应用经济学、法学、翻译硕士（俄语口译）等7个硕士专业。中俄学院拥有在校本科生700余名，研究生140余名。"),
            new Scenic(R.drawable.zhulou,"中法学院(2018)","中法学院是黑龙江大学与法国著名公立大学西巴黎南戴尔拉德芳斯大学合作基础上建设的高层次、国际化教学研究机构。目前中法学院中方院长由黑大研究生院院长、国务院特殊津贴专家、博士生导师焦方义教授担任，法方院长为西巴黎南戴尔拉德芳斯大学前校长玛德福女士。黑龙江大学2014年成立由校党委书记为主任的中法学院管理委员会专门推进中法学院合作建设项目。"),
            new Scenic(R.drawable.zhulou,"哲学学院(2018)\n" +
                    "School of Philosophy","哲学学院的前身是黑龙江大学哲学系，始建于1958年,下设一个本科专业：哲学专业。历经60年发展，哲学专业达到国内一流专业水平。2008年，哲学专业成为“国家级特色专业”建设点，2009年，“黑龙江大学哲学基础理论人才培养模式创新实验区”获批为为国家级人才培养模式创新实验区，2012年，哲学专业成为教育部、财政部支持的高等学校省级“专业综合改革试点”专业。哲学专业为黑龙江省级重点专业，是黑龙江大学拔尖人才培养试点专业。"),
            new Scenic(R.drawable.zhulou,"政府管理学院(2018)\n" +
                    "School of Governmental Administration","黑龙江大学政府管理学院现设有公共管理、政治学、社会学3个系和MPA教育中心，包括行政管理、政治学与行政学、社会学、社会工作、土地资源管理5个本科专业。拥有公共管理博士一级学科学位授予权，管理哲学博士二级学科学位授予权；拥有公共管理、政治学、社会学3个硕士一级学科学位授予权，公共管理硕士（MPA）、社会工作（MSW）2个专业学位授予权。拥有黑龙江省哲学社会科学研究基地“社会管理研究基地”、“文化事业发展研究基地”，黑龙江省高校人文社会科学重点研究基地“行政管理研究中心”。拥有1个国家级教学团队、1门国家级精品课、1门国家级网络资源共享课、1个国家级实践教学基地、一个民政部人才培训基地“国家社会工作人才培训基地”、4门省级精品课。"),
            new Scenic(R.drawable.zhulou,"经济与工商管理学院(2018)","学院概况：经济与工商管理学院具有悠久的发展历史和良好的办学条件，其前身是创立于1960年的黑龙江大学经济系，1991年成立经济学院，2003年正式更名为经济与工商管理学院。经过五十多年的发展，目前已经形成专业设置齐全、学科布局合理，跨经济学、管理学两大学科门类，涵盖理论经济学、应用经济学、工商管理三个一级学科的学科体系。\n" +
                    " 在校生培养：学院现有本科生3000余人，博硕士研究生400余人，是黑龙江大学本科规模最大的学院。 "),
            new Scenic(R.drawable.zhulou,"法学院","黑龙江大学法学院具有30多年的发展历史，其前身法律系创建于1981年，经过30多年的建设和发展，法学专业已跻身全国法学专业的前列，2012年在教育部第三次全国学科评估中，黑龙江大学法学学科在全国630多所法学院系中排名第21位。\n" +
                    "黑龙江大学法学专业的人才培养目标是：培养法学基础扎实，人文素养深厚，具有创新精神和实践能力，能在国家机关、企事业单位、社会团体，特别是能在立法机关、行政机关、检察机关、审判机关、仲裁机构和法律服务机构从事法治实践工作的复合型、应用型高级法律职业人才。"),
            new Scenic(R.drawable.zhulou,"教育科学研究院(2018)","黑龙江大学教育科学研究院的前身是1988年成立的黑龙江大学高等教育研究所。2003年5月，高等教育研究所与应用心理研究所合并成立教育学院。2009年3月，黑龙江大学在教育学院基础上整合学校相关资源成立教育科学研究院（经学校批准，同时使用教育学院一名）。\n" +
                    "学院现设有教育学、应用心理学2个本科专业；拥有教育学硕士一级学科授予权，设有高等教育学、教育经济与管理和教育硕士3个硕士学位点；拥有国家级文科实验教学示范中心下属的2个心理学实验室；是黑龙江省教师资格培训单位。多年来，学院立足龙江，面向全国，为各级各类教育机构、科研院所、大中企业、公检法司等企事业单位输送了近千名教育学、心理学专业的高级专门人才。"),
            new Scenic(R.drawable.zhulou,"文学院(2018)\n" +
                    "School of literature\n","黑龙江大学文学院前身为成立于1958年的中文系，距今已有60年的发展历史，是黑龙江大学历史最悠久、根基最深厚的学院之一。长期以来，学院始终立足本省面向全国，培养了大量的复合型人才，这些莘莘学子在国家机关、企事业单位等各个领域取得了优异的成绩。近年来，学院逐渐发展成为本省一流、国内具有一定影响力的教学科研单位。\n" +
                    "学院下设汉语言文学、汉语国际教育、中国少数民族语言文学三个专业。其中，汉语言文学专业为国家级特色专业，汉语国际教育为省级重点专业。汉语言文学专业设立于1958年，多年来，汉语言文字学研究、古代文学研究成绩卓著；中外文化与文学思潮研究、出土文献整理与典籍研究成绩斐然。汉语国际教育专业设立于2001年，该专业的设立完善了我省乃至整个东北地区的专业结构布局，填补了东北地区专业设计上的一个空白，为传播汉语及汉文化作出了贡献。"),
            new Scenic(R.drawable.zhulou,"新闻传播学院(2018)","黑龙江大学新闻传播学院是黑龙江省新闻人才的摇篮，始建于2005年。历经十余年成长，从1985年招生的新闻学专业一路走来，四千多名优秀的传媒学子从这里走出，传承着它的光荣与梦想。学院的建设和成长完全融入在黑龙江大学人文社会科学学科的发展之中，与黑龙江省、东北地区乃至全国的社会文化传媒建设风雨同舟、血脉相连。目前，新闻传播学院是黑龙江省委宣传部、省委高校工委与黑龙江大学共建学院，是黑龙江省各类传媒人才的培养基地，已成为黑龙江省实力最强、知名度最高的新闻传播学院。 \n" +
                    "新闻传播学院以新闻传播学为主干学科，辅以中国语言文学、市场营销学、戏剧与影视学学科门类。学院现有新闻学、广播电视编导艺术学、广告学、传播学四个本科专业，设有依托学科专业的研究方向，凸显鲜明的专业特色。主要面向党政机关、企事业单位、新闻媒体、广告公司、文化创意产业部门等就业领域，建成了多个省内外具有影响力的专业。"),
            new Scenic(R.drawable.zhulou,"西语学院(2018)\n" +
                    "School of Western Studies","黑龙江大学西语学院前身为1944年成立的延安外国语学校英文系，1957年发展为哈尔滨外国语学院英语系，1958年更名为黑龙江大学英语系,2003年成立西语学院，70余年的办学历史形成了优良的教学传统。学院现设有英语、法语、德语、西班牙语、翻译（英语）和商务英语共6个本科专业，其中英语语言文学为省级重点专业和国家特色专业；拥有英语语言文学博士学位授予权和英语语言文学、德语语言文学、法语语言文学和英语翻译硕士专业学位授予权。"),
            new Scenic(R.drawable.zhulou,"俄语学院(2018)","黑龙江大学俄语专业是我党我军自己缔造的最早的外语人才培养摇篮。在70余年的办学历程中，培养输送了大批高水平俄语人才，为中国革命的胜利、为抗美援朝和新中国建设做出了卓越的贡献。黑大俄语人一直把“服务国家战略”视为自己的崇高光荣与神圣使命，在新世纪继承传统，牢记使命，努力深化教育教学改革，打造鲜明的办学特色，提升人才培养质量，为国家实施对俄全面战略协作提供了人才和智力支撑，为中俄政治经济文化交流与合作做出了重要贡献。\n" +
                    "在适应大众化高等教育的挑战面前，黑大俄语转变教育理念，优化办学模式，打造高端人才、复合人才、应用人才“三位一体、互为支撑、相互渗透”的新型人才培养模式，不仅提升了高端俄语人才的质量和水平，也满足了社会的广泛需求，在新世纪又一次担当起服务国家全方位对俄战略的神圣使命。"),
            new Scenic(R.drawable.zhulou,"东语学院(2018)\n" +
                    "School of Eastern Studies"," 在黑大的大家庭中，有这么一所学院：习东方之语言，品文化之激荡。育交流思辨之英才，显菁菁学子之雄风。这，是培育出无数外语人才的黑龙江大学东语学院。\n" +
                    "黑龙江大学东语学院始建于1964年，前身为黑龙江大学外语系日语专业，1996年经黑龙江省教委批准，更名为东方语言文学系，2003年更名为东语学院。学院师资力量雄厚，办学经验丰富，教学质量突出，为国家培养了大量的外语人才。学院现设有日语、朝鲜语、阿拉伯语3个专业。"),
            new Scenic(R.drawable.zhulou,"艺术学院","黑龙江大学艺术学院始建于2000年，是黑龙江大学最年轻、最具活力和发展潜力的学院之一。学院以素质教育和创新教育等现代艺术教育理念为指导，本着高起点、高素质、高层次、高水平的办学原则，结合地域特色构建了“厚基础、宽口径、重实践”的专业体系。目前，学院拥有视觉传达设计、环境设计、服装与服饰设计、绘画和音乐表演5个本科专业，现有在校生近1400人。学院设五系和两个中心，即视觉传达艺术设计系、建筑环境艺术系、服装艺术设计系、绘画系、音乐系、非物质文化艺术实验示范中心和现代艺术设计研究中心。"),
            new Scenic(R.drawable.zhulou,"历史文化旅游学院(2018)\n" +
                    "School of history culture and tourism","黑龙江大学历史文化旅游学院前身是1959年筹备设立的历史系,国内知名教育家纪昌同志出任第一届历史系主任，2000年3月更名为历史文化旅游学院。至今,学院已经走过了59年沧桑砥砺、奋发自强的道路。\n" +
                    "学院现设有历史学、旅游管理、考古学3个本科专业，拥有中国史、世界史、考古学3个硕士学位一级学科授权点，旅游管理1个硕士学位二级学科授权点。\n" +
                    "历史学和旅游管理专业为省级重点专业，拥有黑龙江流域文明研究中心和黑龙江旅游产业发展研究中心2个省高校重点人文社科研究基地和省高校时尚旅游发展智库。学院还拥有中国北部边疆历史文化研究所、国际礼仪与跨文化沟通研究所和《当代旅游》学术期刊。"),
            new Scenic(R.drawable.zhulou,"数学科学学院(2018)","黑龙江大学数学科学学院的前身是1958年开始招生的数学系，是黑龙江大学更名时的七个系之一。至今，学院的本科教学、科研工作已有60年的悠久历史。作为黑龙江省省级理科基础科学研究与人才培养基地，数学科学学院具有优良的教风、学风。本科毕业生就业率始终在省内同类专业中名列前茅，在计算机、金融、教师、数据分析师等主要就业行业中，我院毕业生受到工作单位的普遍认可。\n" +
                    "黑龙江大学数学科学学院现设有数学与应用数学、信息与计算科学、统计学三个本科专业，数学、统计学两个一级学科硕士科学学位授权点，应用统计硕士专业学位授权点。其中的数学与应用数学专业、信息与计算科学专业为“十二五”黑龙江省普通高等学校重点本科专业。凭借扎实的本科教学和丰富的科研资源不断提升学生的专业素养。该院本科学生多次获得全国数学竞赛和数学建模竞赛一、二等奖，在中俄大学生数学竞赛中，该院学生多次获得大奖，特别是2013年包揽了全部的最高奖项，为黑龙江大学数学科学学院赢得了很高的国际赞誉。"),
            new Scenic(R.drawable.zhulou,"物理科学与技术学院(2018)\n" +
                    "College of Physics Science and Technology","黑龙江大学物理科学与技术学院其前身为1958年开始招生的物理系。历经60年成长，1000多名优秀学子从这里走出，传承它的光荣与梦想。学院的建设和成长融入在黑龙江大学自然科学的发展中，与黑龙江省、东北地区乃至全国的物理科学发展风雨同舟、血脉相连，现已成为黑龙江省物理专业人才的重要培养基地。\n" +
                    "物理科学与技术学院现有物理学、应用物理学两个本科专业，学院依托前沿学科研究和专业特色，建成了具有较强影响力的本科专业。60年来学院为公司、企业、物理科学教育、技术研发单位培养了大批优秀人才。学院也是黑龙江省较早开展物理学、应用物理学研究生教育的单位，现有物理学一级学科硕士学位授予权。"),
            new Scenic(R.drawable.zhulou,"化学化工与材料学院(2018)\n" +
                    "School of chemistry, chemical engineering and materials","黑龙江大学化学化工与材料学院具有60年的建设历史，其前身是1958年开始招生的化学系，是黑龙江大学1958年更名时的七个系之一。化学学科在第四轮教育部学科评估中获得B-，化学、材料和工程学科ESI排名均进入全球机构前1%行列。就业率始终保持在90%左右。学院注重立德树人，2018年荣获黑龙江省优秀教学成果特等奖，曾荣获全国教育系统先进集体、全省教育系统师德建设先进单位等荣誉称号，涌现出了全国道德模范提名奖、全国三好学生标兵等先进个人。\n" +
                    "化学化工与材料学院现设有化学、应用化学、高分子材料与工程、化学工程与工艺、环境科学、制药工程、材料化学7个本科专业。化学专业为国家特色专业，化学、应用化学、材料化学专业为省级重点专业，所有专业均在本科一批次招生。学院现有在校本科生1500多名，硕士、博士研究生近400名。近万名毕业生分布在大专院校、科研院所等教学科研机构；环保、检验、公安、消防、海关、部队等政府部门；石油化工、橡胶塑料、轻工医药、能源新材料等企事业单位，成为具有深厚专业背景的研究人才、技术人才、管理人才和经营人才。"),
            new Scenic(R.drawable.zhulou,"生命科学学院(2018)\n" +
                    "School of Life Science","学院以建设理工科一流学院为目标，以生物产业发展为契机，坚持“产、学、研”相结合的内涵式发展模式，形成了优势互补，产、学、研共同发展的新局面。\n" +
                    "目前学院已经形成了能够授予博士、硕士及学士的多层次、多学科、多专业、成规模的办学局面。\n" +
                    "学院现有生物工程、生物技术、食品科学与工程、生物制药四个本科专业；具有“生态学”一级学科博士学位点，“生物质的化学转化”列入资源化学博士目录外二级学科招生目录，具有“生物学”、“生态学”两个一级学科硕士学位点、“食品加工与安全”农业硕士学位点；拥有农业微生物技术教育部工程研究中心，并以该中心为依托拥有博士后工作站；具有“生物学” 省级领军人才梯队和“生物学”黑龙江省省级重点学科、“微生物学”校级重点学科，由生命科学学院牵头组建的寒地生物学与生态学学科群被列为2018年黑龙江大学高水平大学建设学科；寒区植物基因工程与微生物发酵和寒地生态修复与资源利用两个省级重点实验室，分子生物学和微生物学两个黑龙江省高校重点实验室；黑龙江省高校生物工程研发中心；黑龙江大学安泰生物研究生培养创新示范基地（省级）。与企业共建成立了黑龙江大学丰源食品研究所、黑龙江大学成福生物技术研究中心、黑龙江大学富裕老窖研究所、黑龙江大学舜泰微生物有机肥料研究所、黑龙江大学天通农业生物工程研究所；图书资料室拥有图书1200余册，期刊30余种，包括一个文献检索微机室。"),
            new Scenic(R.drawable.zhulou,"机电工程学院(2018)\n" +
                    "School of Mechanical & Electrical Engineering","在国家振兴东北老工业基地改造和黑龙江省建设哈大齐工业走廊的大背景下，学校从学科战略布局角度以及培养社会急需的应用型高级技术人才出发，于2005年初成立了机电工程学院，并于同年招生。经过十余年的建设，学院各方面都取得了一定成绩，已初具规模。目前学院拥有机械设计制造及其自动化、电气工程及其自动化两个本科专业，一个面向全校本科生实习的黑龙江大学工程训练中心。学院拥有机电一体化理论及应用硕士学位授予权，机电一体化重点实验室，机械工程研究所，电气与电子工程研究所。学院设有大学生创新实验室、机械工程实验室、电气工程实验室。学院现有实习、实验和科研场所八千多平方米，仪器设备资产总值一千六百余万元。\n" +
                    "学院现拥有一支学历层次高、年龄结构优化、知识结构相称、学缘结构理想、理论与实践相结合的教学、科研人员队伍，整个教学团队共35人，其中教授7人，副教授16人，讲师12人；其中硕士生导师9人，在读和已获得博士学位的20余人。"),
            new Scenic(R.drawable.zhulou,"电子工程学院(2018)","黑龙江大学电子工程学院办学历史悠久，始建于1958年。经过58年的建设和发展，形成了学科门类丰富、教学条件优良、师资力量雄厚的人才培养体系。学院现有电子科学与技术（含光电子、微电子两个方向）、电子信息工程2个省级重点专业，自动化、通信工程2个校级重点专业和电子信息科学与技术、集成电路设计与集成系统、物联网工程共7个本科专业。\n" +
                    "学院拥有博士学位授予权和博士后科研流动站。拥有电子科学与技术、控制科学与工程、信息与通信工程3个一级学科硕士学位授予权。拥有微电子学与固体电子学、物理电子学、电路与系统、控制理论与控制工程、检测技术与自动化装置、模式识别与智能系统、信号与信息处理、通信与信息系统8个二级学科硕士学位授予权，并拥有电子与通信工程、控制工程、集成电路工程3个工程硕士点。"),
            new Scenic(R.drawable.zhulou, "计算机科学技术学院(2018)\n" +
                    "School of Computer Science and Technology","黑龙江大学计算机专业创建于1972年，是黑龙江省较早建立的计算机专业之一；1985年，发展成为计算机科学系；2000年，成立计算机科学技术学院。学院现设有计算机科学系、物联网工程系和信息技术研究所三个教学科研单位，拥有计算机科学与技术、物联网工程2个本科专业。其中，计算机科学与技术专业是黑龙江省重点专业和国家级一类特色专业，2012年，该专业入选黑龙江省普通高校“专业综合改革试点”建设项目，同年，被列入“黑龙江大学基础学科拔尖学生培养试验计划”支持项目；物联网工程为国家战略新兴产业新增专业。\n" +
                    "\n" +
                    "学院拥有一支学历高、职称年龄结构合理、学术风气良好的高水平教学科研队伍。目前共有教学科研人员50人，含教授15人、副教授22人，15人具有博士学位，其中，国家杰出青年基金获得者1人，新世纪百千万人才工程国家级人选1人，国家级有突出贡献的优秀中青年专家1人，入选教育部新世纪优秀人才支持计划1人，全国五一劳动奖章获得者1人，国家有突出贡献的出国留学人员1人，国务院特殊津贴专家2人，省杰出青年基金获得者2人，龙江学者1人，省级优秀中青年专家2人，“黑龙江省青年五四奖章”1人。\n" + "学院拥有计算机科学与技术一级学科硕士学位授予权，拥有1个省级重点一级学科、1个省级领军人才梯队、在数据库系统、嵌入式计算与传感器网络、自然语言处理与文本挖掘、媒体计算技术、网络与信息安全、生物信息技术等研究领域形成了较为明显的特色和优势。近年来，学院共承担国家863计划和973计划、国家自然科学基金项目等国家和省部级项目60余项，筹集科研经费1000余万元，获得了以国家科技进步二等奖为标志的20余项省部级以上奖项，出版学术论著10部，在国内外重要学术刊物和会议发表论文500余篇。\n" +
                    "学院拥有国家级教学团队1个、省级教学团队1个、国家级精品课程1门、省级精品课程2门、省级教学名师1人；获得省级教学成果奖5项，省级教学改革项目10项，出版教材13部。学院以学生为本，创新型和应用型人才培养并重。学院注重学生理论联系实际能力的培养，强化实践环节教学，并通过与国内外著名软件企业的合作，采用产学研结合的模式，培养实用型、复合型的计算机专门人才。\n" +
                    "学院拥有数据库与并行计算省级重点实验室、嵌入式计算与传感器网络实验室（该实验室是黑龙江大学-佐治亚州立大学中美联合实验室），同时拥有6个专业实验室和2个创新创业实验室，实验室面积近4000平方米，实验设备先进，科研条件优越，能够充分满足科学研究和人才培养的需要。\n" +
                    "学院积极为学生搭建科技创新舞台，有效提升学生创新实践能力。学院每年均举办ACM程序设计竞赛、软件之星大赛、物联网应用创新大赛等科技活动。四年来，学生参赛队伍取得了以ACM-ICPC亚洲区国际大学生程序设计竞赛银奖、中俄大学生计算机竞赛二等奖、全国大学生程序设计竞赛二等奖、全国机器人创意大赛二等奖等为标志的100余项省级以上奖项。近年来，学院毕业生就业率均在90%以上，得到用人单位的一致好评，就业单位除了各大中型IT企业之外，金融、保险、通信、教育、铁路、油田等行业部门均有所涉及，其中，不乏腾讯科技有限公司、支付宝（中国）网络技术有限公司、五八同城等业界知名企业。同时，该专业拔尖人才培养试验班的学生保研率达到50%，每年均有一批毕业生顺利考取重点院校的硕士研究生。"),
            new Scenic(R.drawable.zhulou,"软件学院(2018)\n" +
                    "School of Softwares","黑龙江大学软件学院成立于2002年，是黑龙江省教育厅首批批准成立的省属示范性软件学院，于2009年被评为“黑龙江省软件服务外包人才培养培训基地”。学院现有1个一级学科硕士学位授予权，1个校级重点学科，设有1个软件工程本科专业，是校级重点专业。\n" +
                    "学院以现代教育理念为指导，以市场需求为导向，以工程技术为主线，充分利用学校计算机学科的优势，通过与国内外著名软件企业的合作，采用产学研结合模式，面向软件行业，为国家和地方培养从事软件开发、软件设计、软件项目管理和软件外包服务等相关工作的工程型、应用型人才。\n" +
                    "学院坚持人才强院战略，形成了一支素质强、水平高、结构优的教学科研队伍，现有专职教师50人，其中教授、副教授37人，具有博士或硕士学位教师45人，拥有全国五一劳动奖章获得者、国家级有突出贡献的优秀中青年专家、国家级有突出贡献的出国留学人员、新世纪百千万人才工程国家级人选、教育部新世纪优秀人才支持计划入选者等高级称谓专家16人次，为教学科研建设提供了强有力的人才保障。\n" +
                    "学院拥有国家级精品课1门，国家级教学团队1支，拥有省级名师1名，省级精品课程2门。学院拥有总面积4000多平米的软件专业实验室和硬件实验室，配置有一流的计算机设备和先进的多媒体教学软件。近年来，学院共承担国家863计划和973计划、国家自然科学基金项目等国家和省部级项目60余项，筹集科研经费1000余万元，获得了以国家科技进步二等奖为标志的20余项省部级以上奖项，出版学术论著10部，在国内外重要学术刊物和会议发表论文500余篇。学院注重学术交流与教学交流，积极聘请国内外著名学者来院讲学，企业资深专家来院授课，并与英国利兹大学、布莱德福德大学、东北大学软件学院、哈尔滨工业大学软件学院等院校保持着良好的交流与合作。\n" +
                    "学院注重结合软件行业发展需要，不断优化课程体系和教学内容，加强实验教学环节，通过增设综合性、设计性实验和课程设计培养学生的动手能力。学院注重实习实践环节，与省内外十几家软件企业合作建立了实习实训基地，通过安排学生到实习基地实习，提高学生的软件设计与实践能力。\n" +
                    "学院积极为学生搭建科技创新舞台，有效提升学生创新实践能力。学院每年均举办ACM程序设计竞赛、软件之星大赛、物联网应用创新大赛等科技活动。四年来，学生参赛队伍取得了以ACM-ICPC亚洲区国际大学生程序设计竞赛银奖、中俄大学生计算机竞赛二等奖、全国大学生程序设计竞赛二等奖、全国机器人创意大赛二等奖等为标志的100余项省级以上奖项。近年来，学院毕业生就业率均在90%以上，得到用人单位的一致好评，就业单位除了各大中型IT企业之外，金融、保险、通信、教育、铁路、油田等行业部门均有所涉及，其中，不乏腾讯科技有限公司、支付宝（中国）网络技术有限公司、五八同城等业界知名企业。"),
            new Scenic(R.drawable.zhulou,"数据科学与技术学院(2018)","数据科学与技术学院的组建源于国家和黑龙江省提出的大数据产业发展战略。在省委省政府的领导下，在黑龙江省教育厅的大力支持下，黑龙江大学依托现有办学资源和学科力量，2017年5月，在原信息科学与技术学院的基础上，正式成立数据科学与技术学院，旨在为黑龙江省大数据产业的发展培养大数据技术与应用人才，促进黑龙江省乃至全国大数据产业的推进与实施。\n" +
                    "2015年国务院印发了《促进大数据发展行动纲要》，高屋建瓴地为大数据在各个领域的应用和发展提供指导。大数据的应用发展与快速推进，使数据成为国家战略资源并成为大数据实际应用的基础。我们黑龙江省也高度重视大数据发展，在《黑龙江省国民经济和社会发展十三五规划纲要》指出：实施大数据战略，整合公共数据资源，构建跨部门的政府数据统一共享交换平台，促进信息系统跨部门互联互通与共享。作为省属重点高校，我校责无旁贷的要为黑龙江省大数据产业的发展提供必要的人才保障和智力支持，数据科学与技术学院的成立，填补了我省大数据本科专业人才培养的历史空白，有效提升为龙江经济建设发展服务的能力，承担起为黑龙江省培养“大数据”专门人才的重任。\n" +
                    "数据科学与技术学院面向国家大数据高端人才的迫切需求，依托学校综合性大学的学科优势，形成合理的教学科研团队，为数据科学的研究，完善大数据技术、管理和服务及人才培养打下了良好的基础，并有效开展以社会需求为导向的大数据应用项目。学院在“大数据战略人才培养工程”中，设置了数据科学与大数据技术、网络空间安全、网络工程三个专业。结合黑龙江省乃至全国大数据产业发展实际，实现产学研一体化的培养体系，采用“双师双轨式”教学模式，学院多名教师参加企业和行业的专业最新技能培训，参与专业核心技术课程和项目实训课程的讲授。\n" +
                    "学院根据信息网络技术发展的最新趋势开展专业教学，在强化学生基础理论的同时，尤为注重学生动手能力的培养，广泛组织学生参加全国互联网+、网络安全、数学建模等高水平科技竞赛，并多次获得优异成绩，增强了学生的就业能力，近年来学生就业率均在95%以上。学院设有网络空间安全硕士学位一级学科授权点和信息统计技术硕士学位学科授权点。学院拥有国家杰出青年基金获得者及一批具有海外留学、国内著名高校博士经历的中青年骨干教师队伍，实验室条件优越，现有28个教学实验室和1个工程实训中心，拥有一流的实验教学设备和先进的多媒体教学设备，设有先进的信息网络技术实验室和计算机应用实验室。"),
            new Scenic(R.drawable.zhulou,"建筑工程学院(2018)","黑龙江大学建筑工程学院设有土木工程、给排水科学与工程两个本科专业和土木工程灾害监测与控制学科硕士点。该学院是以国家卓越工程师培养为目标的教学研究型学院。学院秉持人才强院、质量立院、特色兴院、依法治院的建院方略，经过几十年建设的历史积淀，学院各专业特色鲜明，人才培养质量优异。\n" +
                    "学院坚持学生中心、成果导向、持续改进的人才培养理念，注重学生知识、能力、素质的全面提高。在土木工程、给排水科学与工程专业教学中，坚持厚基础、重实践、强能力，注重学生工程设计能力、工程实践能力和工程创新能力的培养，注重专业特色能力培养和个性化教育，获得工程师基本训练。努力把学生培养成为胜任规划、设计、施工、运营管理等工作的高级工程技术专门人才。\n" +
                    "学院拥有素质强、水平高、结构优的教学科研师资队伍。近年来，学院专任教师完成和承担国家自然科学基金、省部级科研项目近50项、横向课题千万余元，参与大中型工程项目多项，发表高水平论文、出版学术著作、获得各级奖励以及专利授权的数量和层级显著提高。\n" +
                    "学院具备良好的现代化教学设施和实践教学条件，拥有黑龙江省村镇饮水安全工程技术研究中心、东北寒区土木工程技术重点实验室、基础实验中心及相关的专业实验室。其中配备有：长柱实验机、电液伺服万能实验机、电子万能实验机等力学结构实验检测设备，冻土监测系统、混凝土快速冻融试验机等灾害监测及检测设备，大型生物摇床、气相色谱仪、电子流量分析系统、氨氮、总磷、总氮测定仪、BOD测定仪等水质分析检测设备。共有设备1335台套，设备总值1853万元。\n" +
                    "学院重视实习基地建设，建立了中国市政工程华北设计研究总院、中国建筑第二工程局有限公司、方远建设集团股份有限公司、城市水资源开发利用（北方）国家工程研究中心、哈尔滨市利林环保水处理有限公司等多家与专业相关的长期稳定实习基地，能够满足专业实践教学的需要，为学生实践能力的培养提供强有力的支撑。\n" +
                    "学院重视学生创新能力培养，鼓励学生参与省级、校级科技创新课题立项，引导学生参与教师的科研项目，为学生提供参与校内外科技竞赛的平台和机会，学生先后在大学生结构设计竞赛、大学生力学竞赛、招投标模拟大赛、BIM技能大赛等比赛中获奖。\n" +
                    "学院重视学生综合素质提高，利用学生课余时间积极开展形式多样、内容丰富的科技、文化娱乐、体育竞技、社会实践、志愿服务、修身成才教育等学生活动，提升学生人文素养、身心素质和道德品质。学院毕业生得到用人单位的广泛认可，近五年学生就业率达到95%以上，毕业生遍布祖国各地，成为活跃在全国土木和市政专业相关领域的一支重要力量。"),
            new Scenic(R.drawable.zhulou,"水利电力学院(2018)\n" +
                    "School of hydraulic and electric power","黑龙江大学水利电力学院是黑龙江省最早培养水利类人才的摇篮，其水利专业人才培养可以追溯到1956年创立的黑龙江省水利学校，当年设有水利工程、农业水利、陆地水文三个专业。历经，黑龙江水利电力学院、黑龙江水利专科学校，2004年8月经国家教育部批准并入黑龙江大学，同年12月黑龙江大学水利电力学院正式组建成立。\n" +
                    "学院拥有一支教学、科研水平较高的师资队伍，现有专任教师37人，其中教授、副教授23人占学院教师总数62%。学院还聘请中国科学院院士、俄罗斯科学院西伯利亚科学分院院士、美国阿拉斯加大学博导、以及国内重点大学教授为学院客座教授，不定期来学院进行学术交流。\n" +
                    "学院目前设有水利水电工程、农业水利工程、水文与水资源工程3个本科专业。黑龙江大学水利工程实验教学中心被列为省级示范中心，农业水利工程专业入选黑龙江省“卓越农业人才教育培养计划”\n" +
                    "学院拥有水利工程一级学科硕士授权点和土木与水利专业学位硕士授权点,分设寒区水文与雪冰工程、水利水电工程、水文学与水资源等二级学科方向。建有寒区水利工程校级重点实验室、寒区地下水研究所、寒区水文与水利工程中俄联合实验室、黑龙江省地温能学会寒区水文地质专业委员会、黑龙江省水利学会地下水专业委员会等平台。\n" +
                    "学院坚持“心系水利、立足边寒、服务龙江”，以“地方水利+特色水利”为主要科研方向，基于黑龙江省，突出寒区水利和国际河流研究特色。承担国家科技支撑项目、国家自然科学基金、黑龙江省自然科学基金、地方重大水利工程科技支撑项目等各类科研项目100余项。学院持续组织主办有“寒区水资源及其可持续利用”系列学术研讨会，承办了第10届“国际冻土工程会议”、第8届“中国水论坛”、第15届“全国水利量测技术会议”、第9届“全国冰工程学术研讨会”等学术交流活动。主持出版了“寒区水科学及国际河流研究”系列丛书等学术著作。\n" +
                    "学院在积极与中国科学院西北院、中国科学院东北地理研究所、吉林大学、河海大学、大连理工大学、云南大学等国内水利科研机构开展科研协作、学术交流的同时，还密切与俄罗斯、美国、挪威、芬兰、法国等开展国际交流，与俄罗斯科学院西伯利亚分院麦尔尼克冻土研究所、俄罗斯东北联邦大学、美国阿拉斯加大学等世界著名寒区科研机构签订了国际合作协议，并开展了共建联合实验室、学者互访、研究生培养等切实的交流协作。\n" +
                    "学院以培养应用创新型工程技术人才为目标，注重学生人文素奍、科学素质、创新精神的培养。近年来，学院学生参加全国大学生水利创新设计赛等国家级、省级、校级大学生创新创业项目、实验室开放金项目，取得了优异成绩。学院学生在积极参加学校各类社团开展的丰富多彩活动的同时，还依托本院组织开展哈尔滨周边水利考察、科技会议服务、河长制夏令营、寒区水文地理知识系列竞赛等活动。\n" +
                    "学院每年毕业生就业率保持在90%以上，毕业生考研升学率超过20%；在国有大型施工企业就业超过40%；在公务员、事业单位就业占30%多。"),
            new Scenic(R.drawable.zhulou,"农业资源与环境学院(2018)\n" +
                    "School of Agricultural Resources and Environment","一、学院基本概况\n" +
                    "黑龙江大学农业资源与环境学院成立于2003年，是黑龙江省土壤肥料学会、黑龙江省植物保护学会、黑龙江省植物病理学会、黑龙江省环境科学学会等理事单位。\n" +
                    "学院目前设有农业资源与环境、植物保护和种子科学与工程3个本科专业，其中农业资源与环境专业2013年获批黑龙江省卓越农业人才培养试点专业。专业特色为环境生态，依托综合性大学优势，培养理论与实践相结合的卓越农业技术人才。\n" +
                    "二、师资力量\n" +
                    "学院师资力量较强，拥有一批“高学历、高职称”的教师队伍。现有专任教师33人，教授9人，副教授19人，高级职称占84.85%；具有博士学位教师占专任教师总数73.76%；外校学缘比例达到97.06%。教师中有黑龙江省土壤肥料学会副理事长李丽教授、黑龙江省生态学会副理事长王庆贵教授、黑龙江省植物病理学会副理事长马淑梅教授；中国土壤学会理事、黑龙江省土壤肥料学会常务理事、副秘书长焦晓光教授、黑龙江省种子协会副秘书长王洋教授等，同时聘任了多名国内外著名学者、专家、企事业高级管理人员作客座教授。\n" +
                    "\n" +
                    "三、科研平台\n" +
                    "学院现有植物保护一级学科硕士学位授权点，农业推广硕士（植保领域）专业学位点和农药工程技术研究中心博士后工作站，2018年1月获批共建生态学博士点。\n" +
                    "拥有中国农科院农业立体污染防治与产地环境质量黑龙江综合示范基地、黑龙江省农药工程技术研究中心和黑龙江省玉米育种工程中心、“黑龙江大学土壤生态学”和“黑龙江大学作物逆境研究”2个校级重点实验室。2017年12月获批共建省级重点实验室“黑龙江省寒地生态修复与资源利用”。\n" +
                    "四、交流合作\n" +
                    "学院自成立以来，始终高度重视对外交流合作，特别是2015年取得了突破性进展。2015年5月和10月，先后邀请芬兰赫尔辛基大学环境科学系HeikkiSetälä教授、VesaYli-Prlkonen博士、Martin Romantschuk教授和Nan Hui博士于阳光讲坛进行讲学；2015年7月，聘请美国阿肯色州立大学土壤与环境科学系陈鹏印教授为客座教授来学院讲学； 2015年11月，成功加盟“国际持久性有毒物质联合研究中心”，成为该中心第21个成员单位；2015年12月，与美国德克萨斯农工大学金斯维尔分校初步达成在教学、科研、学生培养等方面的合作意向；2017年与与俄罗斯远东分院生物多样性研究中心签订了校所合作协议，多维度开展教学、科研等方面工作。\n" +
                    "五、在校生培养\n" +
                    "学院建立了中国科学院海伦农业生态实验站、农业部谷物及制品质量监督检验测试中心（哈尔滨）、黑龙江省农科院植保所和土肥所、深圳市诺普信农资销售有限公司、陕西农心投资控股有限公司和根力多生物科技股份有限公司等18个实践教学和就业实习基地。2017年11月与西北著名企业、全国百强农药企业、中国农药行业制剂前十强的陕西农心投资控股有限公司签署战略合作协议，加快“以职业需求为导向，以质量提升为核心，以协同育人为切点”的人才培养模式的探索与实践。\n" +
                    "学院非常注重学生综合素质的培养，鼓励学生全面发展，在学校各类学生活动中取得了突出成绩。\n" +
                    "2013年取得校第四十六届田径运动会男女团体总分第三名的好成绩，近五年团体总分三次进入前八名。2009级学生王开月，积极参与公益事业和志愿服务，贡献突出，2013年当选为“黑龙江省大学生年度人物”；2012级学生许淞代表学校参加2014年黑龙江省大学生羽毛球锦标赛，获得甲组团体赛第三名。同时，在学生工作中注重依托专业优势，着力开展暑期“三下乡”社会实践活动和绿色环保活动，连续多年被评为黑龙江大学暑期“三下乡”社会实践活动先进单位；2013年获得黑龙江省“万名大学生进万村”优秀团队荣誉称号。2016年学院申报课题《井冈山红米产业化典型案例调查研究》参与2016年“井冈情·中国梦”全国大学生暑期实践季专项活动，被团中央学校部评为全国优秀团队。2017年学院参与全国农科学子联合实践行动，赴富锦市建三江七星农场开展科技帮扶工作，被团中央评为“全国农科学子助力脱贫攻坚暑期专项活动优秀团队”。\n" +
                    "六、就业方向\n" +
                    "毕业生就业主要分布在高校、科研院所，省、市、地、县各级农业行政管理部门、农业推广部门、涉农公司等各类企事业单位，就业率达90%以上，考研率为25%以上，多名学生以优异的成绩考取了北京大学、中国农业大学、中国科学院和中国农业科学院等国内著名大学及科研院所。 "),
            new Scenic(R.drawable.zhulou,"信息管理学院(2018)\n" +
                    "School of Information Management","黑龙江大学信息管理学院成立于2001年，其前身是始建于1984年的图书情报学系。学院秉承“协作发展、创新求实、德美勤勉”的院训，立足于黑龙江省经济建设和社会发展，辐射全国，面向政府机关、企事业单位、科研院所培养了5000多名从事图书档案管理与服务、编辑出版、电子商务活动以及信息系统分析、设计、实施管理和评价等方面的高级专门人才，为我国的信息化建设事业做出了应有的贡献。\n" +
                    "经过30多年的发展建设，学院在教学、科研和学科建设上取得了丰富的成果。在本科教学方面，学院现有图书馆学、档案学、编辑出版学、信息管理与信息系统、电子商务5个本科专业，其中图书馆学、档案学、编辑出版学3个专业为黑龙江省惟一的全日制本科专业，图书馆学、档案学专业为省级重点专业，档案学专业为省“十二五”期间本科教学改革试点专业。在学科建设方面，学院拥有文献信息学二级学科博士学位授予权，拥有省内唯一的图书情报与档案管理一级学科硕士学位授予权，拥有图书馆学、情报学、档案学三个二级学科硕士学位授予权，拥有管理科学与工程一级学科硕士学位授予权，同时图书情报硕士专业学位授予权。在科研方面，近5年来承担国家社科基金项目20项，教育部人文社科项目6项，获得教育部高等学校科学研究优秀成果奖1项，编写教材专著10余部，发表论文200余篇。\n" +
                    "学院的发展离不开一支高素质的教师队伍。目前，学院现有教职工45人，其中行政人员9人，专职教师36人，其中教授12人，副教授21人，博士后3人，在站博士后1人，博士16人，在读博士3人，博士生导师2人，硕士生导师30人，拥有博士、硕士学位的教师占全院教师总数的92%。拥有国家级精品课1门，省级教学团队1个，享受国务院政府特殊津贴1人，入选教育部“新世纪优秀人才支持计划”1人，省级教学名师1人，二级教授1人，三级教授3人。\n" +
                    "学院人才培养模式是在加强学生基础知识和理论学习的同时，注重以社会需求为导向，培养学生的动手能力和创新思维。为此，学院建立了完善的实践教学平台，建有跨图书情报与档案管理一级学科的黑龙江省高校人文社会科学重点研究基地——信息资源管理研究中心和校级创业教育试点单位——信息管理学院创业教育基地；拥有信息处理、物流模拟、文献信息管理、档案整理、档案保护技术、档案复制技术、编辑出版等实验室；与黑龙江省图书馆、黑龙江省档案馆、黑龙江省科技情报所等20多家单位建立了长期的实习实训基地。学院积极创造条件鼓励学生参与社会实践和创新创业活动，努力实现教学与社会需求的对接，从而达到较高的就业率。\n" +
                    "学院现有在校生1000余名，始终注重培养学生创新能力和实践能力，满足学生个性化发展需求，促进学生成长成才，全面发展。学院曾获得“黑龙江省学生工作先进集体”、“黑龙江省青年志愿者行动优秀青年志愿服务集体”等荣誉称号。2010年以来，我院学生在全国大学生电子商务大赛、全国大学生“用友杯”沙滩模拟经营大赛、全国大学生管理决策模拟大赛、全国大学生数学建模大赛、黑龙江省“方正杯”排版大赛、哈尔滨大学生创业大赛等比赛中均斩获奖项。\n" +
                    "协作、创新、勤勉，信息管理学院期待你的加入!"),
            new Scenic(R.drawable.zhulou,"应用外语学院介绍\n" +
                    "College of Applied Foreign Languages","黑龙江大学应用外语学院的前身为1985年成立的黑龙江大学公共外语教学研究部。自1997年起开设应用英语专业。2007年，学校成立应用外语学院，与外语教学研究部合署办公。2009年，应用英语专业正式更名为商务英语专业，2015年开设商务俄语专业。经过近30年的发展已经成为了综合实力较强，发展势头良好的外语类学院。\n" +
                    "应用外语学院招收商务英语本科专业和商务俄语本科专业学生。所培养的学生就业能力强，直接服务于社会与经济的发展。学院是教育部高等学校英语类教学指导分委员会商务英语专业教学协作组副组长单位，全国国际商务英语研究会副理事长单位、黑龙江省商务英语学会会长单位、黑龙江省外语教育学术交流基地主任单位。黑龙江大学“外国语言学及应用语言学”硕士学位点、“翻译硕士（英语笔译）”学位点和黑龙江大学应用英语研究所设在该院。\n" +
                    "学院师资力量雄厚，拥有一支由教授、副教授、博士生导师、硕士生导师和省级教学名师组成的专业教师队伍和资深的兼职专业教师队伍，并常年聘有来自美国、英国、加拿大、澳大利亚、俄罗斯等国的外籍教师任教。近年来，学院教师先后承担国家、教育部、黑龙江省社科规划项目。并获得国家级和省优秀教学成果奖。《大学英语跨文化交际》被评为国家级精品课，《商务英语IV》和《商务英语视听说III》获得全国多媒体课件大赛国家一等奖和创意奖。学院编写教材多部，其中《商务沟通》、《大学英语跨文化交际》、《新通用大学英语》、《商务沟通实践教程》教材被列入国家级“十一五”规划教材。《体验商务英语综合教程5（第二版）》教材被列入国家级“十二五”规划教材。学院还编写国内首套商务俄语教材12本。\n" +
                    "学院教学设施齐备，院资料室藏有大量国外引进图书、期刊和音像资料，学生专用教室配有闭路电视、台式电脑、投影仪、原版英文图书等供教师和学生使用。\n" +
                    "学院坚持以学生为本的育人理念，以素质教育为中心，在继承中发展，在改革中创新，强化思想政治教育、推进学术科研活动、完善科学管理职能、重视校园文化建设，培养学生严谨自律的意识，营造浓厚的学习氛围。\n" +
                    "学院高度重视学生的学风建设，实行新生早晚自习、课堂考勤、学业预警等制度以加强学风建设，配备学业班主任指导学生进行专业学习。并通过组织各类专业讲座、专业交流活动培养学生学习兴趣，提高学生自主学习和研究性学习能力。学院坚持打造丰富多彩的第二课堂活动，以英语角、英语演讲比赛、商务英语系列大赛等特色活动展示了专业风采；以五月风采晚会、男生日、趣味运动会等文体活动拉近师生距离。"),
            new Scenic(R.drawable.zhulou,"满族语言文化研究中心","黑龙江大学满族语言文化研究中心组建于1999年，其前身为黑龙江省满语研究所。目前研究中心成员10人，其中研究员（教授）4人，副研究员（副教授）2人，助理研究员（讲师）3人。成员中博士研究生导师3人，硕士研究生导师6人，有博士学位者5人。学科骨干成员学缘结构、知识结构、学历结构、年龄结构合理，具有很强的群体优势。此外，研究中心还有一支成员达55人的规模宏大的特聘研究员（教授）队伍，其中包括韩国、日本、台湾、香港等海外学者。\n" +
                    "\n" +
                    "积淀深厚的专业研究建构\n" +
                    "经过几代人的不懈努力，研究中心现在已经成为全国满学领域里机构创建最早，学科体系架构（科研、教学、期刊）最完善的专门研究满通古斯语言文化的科研教学机构。研究中心主持完成国内、国际合作项目多项，出版专著、编著多部，在国内外重要学术刊物上发表学术论文多篇，有多项研究成果获各级奖项。\n" +
                    "中心的研究课题既立足于传统优势领域又密切关注当下的理论前沿，主要研究方向有满语基础理论研究、满族语言与历史文化研究、满通古斯语言文化抢救调查研究与数字化处理、满语文翻译与应用研究、满族语言文化与相关民族语言文化比较研究、满族语言文化模式研究、满通古斯语言文化与人类学研究等。\n" +
                    "\n" +
                    "结构健全的人才培养体系\n" +
                    "目前，黑龙江大学拥有全国唯一从本科、硕士到博士最为完整的满语文专业高等教育体系。2000年设立硕士学位点，2002年开始招生，共招收12届研究生40人，至今已有9届毕业；自2005年开始，共招收2005级、2007级、2009级与2011级“满文与历史文化”专业本科生四届共计66人,目前在读学生13人；自2007年在汉语言文字学专业汉语言文化与北方民族语言文化关系、汉语言与北方民族语言比较研究方向招收培养博士研究生；自2012年起设立中国少数民族语言文学（满通古斯语族）博士点，招收博士研究生9人。\n" +
                    "\n" +
                    "闻名遐迩的学术期刊\n" +
                    "《满语研究》学术期刊创办于1985年，是目前世界上惟一专门刊登满通古斯语言文化研究成果的学术期刊。系国家百种重点社科期刊、中国期刊方阵双效期刊、中国中文核心期刊、全国优秀社科学报、国际学术交流期刊，为CSSCI来源扩展期刊、中国社科院核心期刊，发行于日、美、俄、韩等近20个国家及港台地区，在国内外学术界具有重要的影响。\n" +
                    "\n" +
                    "色彩鲜明的专业特色\n" +
                    "本科专业汉语言文学（满语）专业基于“厚基础、重创新、强能力、高素质”的专业特色，培养符合时代要求，具有扎实的满语文基础，良好的理论素养，较好的分析问题与解决问题的能力，具有学科发展前沿知识、较强创新精神与自主科学研究和实践能力，能在国家机关、文教事业、文博档案等机构从事实际工作的应用型高级专门紧缺人才。\n" +
                    "设置主要课程有基础满语、满语语法、语言学理论与方法、语音学、满语词汇研究、阿尔泰语言学概论、历史比较语言学、满族史、东北民族关系史、满文文献导读、满文档案整理与研究、文化人类学等。"),
            new Scenic(R.drawable.zhulou,"国际文化教育学院","黑龙江大学为适应21世纪高等教育国际化发展趋势，依托外语学科传统优势，确立了开放、互动、多层次、国际化的办学模式，成立了国际文化教育学院，并于2001年开始正式招收中外合作办学项目的全日制本科学生。作为黑龙江大学二十八个本科基础教学单位之一，国际文化教育学院每年招收来自全世界近100个国家的长短期留学生1500余人，同时招收中外联合培养的中国学生120人，学院集教学、管理、服务于一体，通过与国外大学间教育资源的互补与共享，积极探索“以学生交流为手段，全面促进国际交流与合作，大力推进全方位开放式办学”之路，努力培养具有国际竞争力的复合型人才。\n" +
                    "黑龙江大学与英国英国斯旺西大学、布莱德福德大学建立联合培养学生项目，学生在黑龙江大学国际文化教育学院学习本科前三年的课程，符合条件的学生可以选择赴英国合作大学学习对应专业本科最后一年的课程，成绩合格者将获得黑龙江大学的本科毕业证书和学位证书。达到英国大学硕士入学标准的学生可以申请继续攻读英国大学的硕士研究生课程，成绩合格者将获得英国大学的硕士学位证书。\n" +
                    "国际文化教育学院始终坚持以教育教学为中心，以提高教学质量为宗旨，拥有一支知识结构完整、教学经验丰富的中外教师团队。为了迎合当今社会对外语类复合型人才的需求，同时满足学生在英国学习的语言标准，国际文化教育学院参考国外大学的教育教学特点，单独编制教学计划，除学生在校所学的必备专业课外，大量增加了英语教学的课程门数和课时数，同时邀请国外大学教师来学校讲授部分专业课程，使教学内容更加丰富饱满，并通过特有的小班授课，保证了一流的教学质量。\n" +
                    "学生从入学开始从听、说、读、写全面强化英语，从而奠定良好的英语学习基础，为他们学习在第二及第三学年开设的双语专业课扫清语言障碍。按照培养计划，符合出国条件者在第四学年可以选择到国外学习，在英国学习期间可以得到减免部分学费以及获得不同程度奖学金的优惠政策；未达到出国要求的学生，将在国内完成全部学业内容并获得黑龙江大学的本科毕业证书和学位证书。\n" +
                    "国际文化教育学院坚持将学风建设和校园文化生活有机结合，形成了学生在参加活动时增长知识、在刻苦学习时陶冶情操的独特管理模式。通过组织学生参加“国际杯”英语演讲比赛、英语文化节、模拟联合国大会，以及与国外学生共同开展课外活动和学术研讨活动等，不断提高学生外语应用能力及社会实践能力，为学生搭建了独具特色的校园文化平台。\n" +
                    "自2001年起，国际文化教育学院以联合培养和交换留学的方式成功派遣了1600余名学生出国留学，90%以上的学生选择再过为继续求学深造，攻读硕士、博士学位，并找到了理想的工作。以在英国布莱德福德大学硕博连读后任教于英国斯旺西大学的2002届毕业生李悦为代表的一大批学生留在国外大学任教；以在牛津大学获得博士学位后就职于中国人民大学的2005届毕业生吕文威为代表的一大批学生回国后在高校任教；以在诺丁汉大学获得硕士学位后在联想集团担任台式机研发部主管的2006届毕业生吕昂为代表的一大批学生回国后在大型企业任职。而以2006届毕业生杨博超为代表的未选择出国的毕业生们也凭借在国际文化教育学院学习过程中的外语优势在研究生考试、公务员考试中获得极大优势，杨博超因品学兼优在本科毕业后被保送至哈尔滨工业大学攻读硕士学位，后被公派到爱尔兰国立高威大学攻读博士学位。国际文化教育学院培养的是精通外语、专业知识过硬的复合型人才，在求职过程中深得外资、合资企业青睐。目前，黑龙江大学国际文化教育学院的优秀学子遍布于世界各地，正在成为国际舞台中的璀璨新星。")




    };

    private List<Scenic> scenicList = new ArrayList<>();

    private ScenicAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);

        iniScenic();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.attractions_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this , 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ScenicAdapter(scenicList);
        recyclerView.setAdapter(adapter);
    }

    private void iniScenic(){
        scenicList.clear();
        for ( int i = 0 ; i < scenics.length ; i ++ ){
            Random random = new Random();
            int index = random.nextInt(scenics.length);
            scenicList.add(scenics[index]);
        }
    }

}
