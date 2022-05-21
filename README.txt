这是作者的第一个Minecraft forge模组，比较粗糙，望见谅。
这个模组的目的是做出比原版音符盒更好的阴符盒，也就是模组名b(e)t(ter)note的由来。
这个系列将由作者一人完成大部分内容，会用于今年暑期将要发布的开发讲解视频，可能会由@MC资讯网工作室发布至网易。
这个模组说实话没啥难度，就开源了。

Changelog:
=================================
release 3.0.2
上了几天网课，再写一个版本
Add:the timbre of strings
    a block specially for the timbre of piano
Bug:some sounds can't be played properly when noteblock is powered,but can be played by commandline or command block.(already been fixed in beta version)
    some block property can't be load properly(already fixed)

Add:加入了弦乐器组的音色
    加入了一个单独的钢琴方块，使用了不同于模组原来的音色（beta中单独commit）
Bug:一些声音不能在音符盒上正常播放，但是可以通过指令或命令方块来播放（已在beta版本中修复）
    一些钢琴方块的属性不被正确读取（已在beta版本中修复）
=================================
release 2.4.92
Nothing important

没啥可说的，中考前最后一更了
主要就是加了个古典吉他的音色
=================================
release 2.4.71(beta)
fix: correct the profiles of electric piano
     fixed the bug mentioned in release 2.3.95
     
fix: 修正了电钢琴的声音文件
     修复了PropertyInteger PITCH在重载后丢失的bug
=================================
release 2.3.94
Add: make the module logically complete and playable in the survival and creation modes
     The timbre of piano and electric piano is added
Bug: the data of PropertyInteger pitch will be lost after reentering the world (back to default set)

add：使模组在生存和创造模式下都逻辑完整且具有可玩性
     加入了钢琴，电钢琴的音色
bug：PropertyInteger PITCH的数据在重新进入世界后会丢失（回到Default set）
