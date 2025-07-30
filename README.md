# What to Eat - 今日吃什么

一个帮助你解决"今天吃什么"这一世纪难题的 Android 应用。

## 项目介绍

你是否经常为每天吃什么而烦恼？面对冰箱里的食材不知如何搭配？[What to Eat](file:///C:/Users/jeong/Desktop/What_to_eat/app/src/main/java/com/jeongyeham/what_to_eat/ui/about/AboutFragment.kt#L30-L30) 应用旨在帮助你快速做出饮食决策，让你不再为选择吃什么而纠结。

## 功能特性

1. **随机食物选择** - 在主页点击按钮，应用会为你随机推荐一种食物
2. **食物管理** - 在 Dashboard 页面可以添加或删除食物选项，自定义你的食物列表
3. **趣味彩蛋** - 关于页面中，连续点击作者名字5次可以显示作者头像

## 技术栈

- **语言**: Kotlin
- **架构**: 基于 Android Navigation Component 的单 Activity 多 Fragment 架构
- **主要库**:
  - Jetpack Navigation: 页面导航
  - Room Database: 本地数据存储
  - ViewBinding: 视图绑定
  - Material Design: UI 设计

## 构建和运行

### 环境要求

- Android Studio
- JDK 11 或更高版本
- Android SDK API 35 或更高版本

### 构建步骤

1. 克隆项目到本地:
   ```
   git clone <项目地址>
   ```

2. 使用 Android Studio 打开项目

3. 同步 Gradle 依赖

4. 构建并运行应用:
   ```
   ./gradlew assembleDebug
   ```

## 项目结构

```
com.jeongyeham.what_to_eat
├── data/               # 数据层，包含数据库相关代码
├── model/              # 数据模型
├── ui/
│   ├── home/           # 主页 - 随机选择食物功能
│   ├── dashboard/      # 管理页 - 食物列表管理
│   └── about/          # 关于页 - 应用信息和彩蛋
└── MainActivity.kt     # 主入口 Activity
```

## 数据库设计

使用 Room 数据库存储食物列表信息，包含:
- Food Entity: 食物实体类
- Food DAO: 数据访问对象
- AppDatabase: 应用数据库

## 开发者

[@Jeong Yeham](file:///C:/Users/jeong/Desktop/What_to_eat/app/src/main/java/com/jeongyeham/what_to_eat/ui/about/AboutFragment.kt#L30-L30)

## 许可证

本项目仅供学习交流使用。