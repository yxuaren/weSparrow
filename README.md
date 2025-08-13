# weSparrow

# Project Plan for a Card Battle Mobile Game  
**卡牌手游项目计划书**

## 1. Project Overview / 整体项目概述
**EN:**  
This project aims to develop a cross-platform strategy card game for both Android and iOS devices. The core gameplay will be a deep strategic experience where players build custom decks to compete against each other. The game will feature a unique blend of competitive PvP, engaging PvE challenges, and a robust card collection system, all designed to offer a fresh and highly replayable experience. The project emphasizes intuitive design, seamless cross-platform functionality, and a balanced monetization model to ensure long-term success. We will leverage a modern Java-based technology stack to guarantee efficient development and a high-performance, stable game environment.

**CN:**  
本项目旨在开发一款跨平台的卡牌策略手游，支持 Android 和 iOS 设备。游戏核心玩法为深度策略体验，玩家通过构筑自定义卡组进行对战。游戏将融合竞技性强的玩家对战、引人入胜的 PvE 挑战和完善的卡牌收集系统，旨在提供新颖且高可玩性的游戏体验。项目将重点关注直观设计、流畅的跨平台功能和平衡的商业化模式，以确保游戏的长期成功。我们将利用现代化的 Java 技术栈，保障开发效率和高性能、稳定的游戏环境。

---

## 2. Feature List / 功能列表

### 2.1 Core Gameplay Features / 核心玩法功能
**Player-versus-Player (PvP) System / 玩家对战系统**
- **Ranked Matchmaking**: Match players with similar skill levels.  
- **Seasonal Ranking**: Competitive ladder with seasonal resets and rewards.  
- **Friendly Duels**: Invite friends for private matches.

**Card & Deck System / 卡牌与卡组系统**
- **Card Collection**: Diverse cards with unique abilities and rarities.  
- **Custom Deck Building**: Build and save multiple decks.  
- **Crafting & Disenchanting**: Convert unwanted cards into resources for crafting new ones.

---

### 2.2 Monetization & Account Systems / 商业化与账户系统
**Monetization / 货币化系统**
- **In-game Currency**: Gold, Gems, and other virtual currencies.  
- **Payment Integration**: Stripe & PayPal support for purchasing items.

**Booster Pack Purchase System / 卡包购买系统**
- **Standard Packs**: Buyable with in-game or premium currency.  
- **Limited-Time Offers**: Exclusive packs available for short periods.

---

### 2.3 Player Interaction & Social Features / 玩家交互与社交
- **Player Profile**: Customizable profile with stats, rank, and achievements.  
- **Friends System**: Add, manage, and chat with friends.  
- **Quests & Achievements**: Daily and long-term rewards.

---

### 2.4 Player-versus-Environment (PvE) Content / PVE 内容
- **Challenge Mode**: Series of AI battles with unique mechanics and difficulty scaling.

---

## 3. Technology Stack / 技术栈选择
- **Game Engine / 游戏引擎**: Unity3D  
- **Backend Service / 后端服务**: Java + Spring Boot  
- **Databases / 数据库**:  
  - PostgreSQL (structured data)  
  - Redis (caching)  
- **Payment Gateways / 支付网关**: Stripe SDK, PayPal SDK  
- **Version Control / 版本控制**: Git + GitHub  
- **Deployment / 部署与运维**: Docker, GitHub Actions / Jenkins

---

## 4. Functional Modules & Interactions / 功能模块与交互关系

**Main Modules / 主要模块**
- **Client (Unity)**: UI, UX, gameplay logic.  
- **Backend (Spring Boot)**: Business logic, matchmaking, payment, social features.  
- **Account Service**: Authentication, user data.  
- **Matchmaking Service**: Match creation & management.  
- **Game Logic Service**: In-game actions, card effects, results.  
- **Payment Service**: Integrations with Stripe/PayPal.  
- **Social Service**: Friends, chat, player interactions.

**Interactions / 交互**
- Client ↔ Backend: REST API + WebSockets for real-time.  
- Backend ↔ Databases: PostgreSQL via JPA/Hibernate, Redis for caching.  
- Payment Service ↔ Stripe/PayPal APIs.

---

## 5. Detailed Phased Implementation Plan / 详细分步实现计划

### **Phase 1: Core Gameplay Prototype (1–2 months)**  
**第一阶段：核心原型开发（1–2个月）**  
- **Client**: Unity project setup, battle UI, basic gameplay mechanics.  
- **Backend**: Spring Boot setup, PostgreSQL integration, simple AI.  
- **Milestone**: Playable AI match.

---

### **Phase 2: Monetization & Deck Building (2–3 months)**  
**第二阶段：功能完善与商业化接入（2–3个月）**  
- **Client**: Deck management, card collection, booster pack purchase UI.  
- **Backend**: Stripe/PayPal integration, currency management.  
- **Milestone**: Full commercial loop, deck customization.

---

### **Phase 3: Multiplayer & Social Features (3–4 months)**  
**第三阶段：多人对战与社交系统（3–4个月）**  
- **Client**: Ranked ladder UI, matchmaking, friends & chat.  
- **Backend**: Real-time matchmaking, ranking algorithm, WebSocket comms.  
- **Milestone**: Real-time PvP matches, basic social features.

---

### **Phase 4: PvE Content & Optimization (4–5 months)**  
**第四阶段：PVE 内容与优化（4–5个月）**  
- **Client**: Challenge mode UI, unique AI battles.  
- **Backend**: AI logic for PvE, performance optimization.  
- **Milestone**: All features complete, ready for closed beta.
