create table dashboard_map
(
    id varchar(64) not null comment '角色id或者用户名',
    module_type enum('CONFIGURE', 'ANALYSIS') default 'CONFIGURE' not null comment '功能模块, CONFIGURE:组合配置  ANALYSIS:情景分析 (2022-12-31,角色看板只有组合配置)',
    layout enum('BAR_CHART_LAYOUT', 'LINE_CHART_LAYOUT', 'POSITION_DETAIL') default 'BAR_CHART_LAYOUT' not null comment '图表类型, BAR_CHART_LAYOUT:柱状图  LINE_CHART_LAYOUT:折线图, POSITION_DETAIL:表格',
    factor_code tinytext null comment '因子代码',
    tag_category_code varchar(64) null comment '标签分类代码',
    start_date date null comment '展示数据的起始时间',
    end_date date null comment '展示数据的结束时间',
    create_time datetime null,
    update_time datetime null,
    primary key (id, module_type, layout)
)
    comment '看板关系表';

