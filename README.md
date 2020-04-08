# Dialog

Brief



## 效果图

| 序号 | 类                       | Style                         | 效果图                                                       |
| ---- | ------------------------ | ----------------------------- | ------------------------------------------------------------ |
| 1    | CommonDialog             | -                             | <img src="screenShots/CommonDialog.jpg" alt="img" width="500px" /> |
| 2    | TextListDialog           | -                             | <img src="screenShots/TextListDialog-0.jpg" alt="img" width="500px" /> |
| 3    | TextListDialog           | Style_NoTitle                 | <img src="screenShots/TextListDialog-1.jpg" alt="img" width="500px" /> |
| 4    | TextListDialog           | Style_NoTitle_TextCenter      | <img src="screenShots/TextListDialog-2.jpg" alt="img" width="500px" /> |
| 5    | IconTextListDialog       | -                             | <img src="screenShots/IconTextListDialog-0.jpg" alt="img" width="500px" /> |
| 6    | IconTextListDialog       | Style_NoTitle                 | <img src="screenShots/IconTextListDialog-1.jpg" alt="img" width="500px" /> |
| 7    | IconTextListDialog       | Style_TitleCenter             | <img src="screenShots/IconTextListDialog-2.jpg" alt="img" width="500px" /> |
| 8    | BottomTextListDialog     | -                             | <img src="screenShots/BottomTextListDialog-0.jpg" alt="img" width="500px" /> |
| 9    | BottomTextListDialog     | Style_NoCancelButton          | <img src="screenShots/BottomTextListDialog-1.jpg" alt="img" width="500px" /> |
| 10   | BottomTextListDialog     | Style_TextLeft_NoCancelButton | <img src="screenShots/BottomTextListDialog-2.jpg" alt="img" width="500px" /> |
| 11   | BottomIconTextListDialog | -                             | <img src="screenShots/BottomIconTextListDialog-0.jpg" alt="img" width="500px" /> |
| 12   | BottomIconTextListDialog | Style_NoTitle                 | <img src="screenShots/BottomIconTextListDialog-1.jpg" alt="img" width="500px" /> |
| 13   | BottomIconTextListDialog | Style_TitleCenter             | <img src="screenShots/BottomIconTextListDialog-2.jpg" alt="img" width="500px" /> |



## 简单使用



**序号在上面的表格中查看**



### 序号1（CommonDialog)

```kotlin
val dialog = CommonDialog(this)
with(dialog) {
    setTitle("提示")
    setContent("确定要退出吗？")
    onConfirmClickListener = {
        dialog.dismiss()
    }
    onCancelClickListener = {
        dialog.dismiss()
    }
    show()
}
```



### 序号2（TextListDialog)

```kotlin
val dialog = TextListDialog(this)
dialog.setTitle("选择通知栏样式")
	.setData(listOf("系统样式", "云音乐通知栏", "可以不要右边的对勾"), 1)
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.show()
```



### 序号3（TextListDialog，Style_NoTitle)

```kotlin
val dialog = TextListDialog(this,TextListDialog.Style_NoTitle)
dialog.setData(listOf("系统样式", "云音乐通知栏", "可以不要右边的对勾"), 1)
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.show()
```



### 序号4（TextListDialog，Style_NoTitle_TextCenter)

```kotlin
val dialog = TextListDialog(this,TextListDialog.Style_NoTitle_TextCenter)
dialog.setData(listOf("系统样式", "云音乐通知栏", "可以不要右边的对勾"), 1)
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.show()
```



### 序号5（IconTextListDialog）

```kotlin
val dialog = IconTextListDialog(this)
val data = listOf(
    Pair(R.drawable.ic_qq, "QQ登录")
    , Pair(R.drawable.ic_wechat, "微信登录")
    , Pair(R.drawable.ic_weibo, "微博登录")
)
dialog.setTitle("选择登录方式")
	.setData(data)
	.setOnItemClickListener { v, position ->
 		dialog.dismiss()
	}
	.show()
```



### 序号6（IconTextListDialog，Style_NoTitle)

```kotlin
val dialog = IconTextListDialog(this,IconTextListDialog.Style_NoTitle)
val data = listOf(
    Pair(R.drawable.ic_qq, "QQ登录")
    , Pair(R.drawable.ic_wechat, "微信登录")
    , Pair(R.drawable.ic_weibo, "微博登录")
)
dialog.setData(data)
	.setOnItemClickListener { v, position ->
 		dialog.dismiss()
	}
	.show()
```



### 序号7（IconTextListDialog，Style_TitleCenter)

```kotlin
val dialog = IconTextListDialog(this,IconTextListDialog.Style_TitleCenter)
val data = listOf(
    Pair(R.drawable.ic_qq, "QQ登录")
    , Pair(R.drawable.ic_wechat, "微信登录")
    , Pair(R.drawable.ic_weibo, "微博登录")
)
dialog.setTitle("选择登录方式")
	.setData(data)
	.setOnItemClickListener { v, position ->
 		dialog.dismiss()
	}
	.show()
```



### 序号8（BottomTextListDialog)

```kotlin
val dialog = BottomTextListDialog(this)
dialog.setData(listOf("拍照", "从相册选择", "我编一个选项"))
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.setOnCancelClickListener {
 	   dialog.dismiss()
	}
	.show()
```



### 序号9（BottomTextListDialog，Style_NoCancelButton)

```kotlin
val dialog = BottomTextListDialog(this,BottomTextListDialog.Style_NoCancelButton)
dialog.setData(listOf("拍照", "从相册选择", "我编一个选项"))
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.setOnCancelClickListener {
 	   dialog.dismiss()
	}
	.show()
```



### 序号10（BottomTextListDialog，Style_TextLeft_NoCancelButton)

```kotlin
val dialog = BottomTextListDialog(this,BottomTextListDialog.Style_TextLeft_NoCancelButton)
dialog.setData(listOf("拍照", "从相册选择", "我编一个选项"))
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.setOnCancelClickListener {
 	   dialog.dismiss()
	}
	.show()
```



### 序号11（BottomIconTextListDialog)

```kotlin
val data = listOf(
    Pair(R.drawable.ic_qq, "QQ登录")
    , Pair(R.drawable.ic_wechat, "微信登录")
    , Pair(R.drawable.ic_weibo, "微博登录")
)
val dialog = BottomIconTextListDialog(this)
dialog.setTitle("选择登录方式")
	.setData(data)
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.show()
```



### 序号12（BottomIconTextListDialog，Style_NoTitle)

```kotlin
val data = listOf(
    Pair(R.drawable.ic_qq, "QQ登录")
    , Pair(R.drawable.ic_wechat, "微信登录")
    , Pair(R.drawable.ic_weibo, "微博登录")
)
val dialog = BottomIconTextListDialog(this,BottomIconTextListDialog.Style_NoTitle)
dialog.setData(data)
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.show()
```



### 序号13（BottomIconTextListDialog，Style_TitleCenter)

```kotlin
val data = listOf(
    Pair(R.drawable.ic_qq, "QQ登录")
    , Pair(R.drawable.ic_wechat, "微信登录")
    , Pair(R.drawable.ic_weibo, "微博登录")
)
val dialog = BottomIconTextListDialog(this,BottomIconTextListDialog.Style_TitleCenter)
dialog.setTitle("选择登录方式")
	.setData(data)
	.setOnItemClickListener { v, position ->
		dialog.dismiss()
	}
	.show()
```

