# MathViewer

Based on the jqMath project and making use of **JavaScript** technology in conjunction with Kotlin commands; MathViewer is a mathematical formula renderer that can be used in all kinds of Android projects that need to display complex formulas from algebra, physics, chemistry, etc.

As the author mentions, the jqMath project is light, fast and concise. It is standards-based and cross-browser, using MathML when available, plain HTML and CSS otherwise, and avoiding pixmap images.

The project is developed by Jesus Alejandro Granados Zavala and supported by FunDevs.


# Download

At the moment, the way to implement the library is through the aar file, available in the project releases.

# How do I use MathViewer?

1. To use the MathViewer library, make sure there is a link to it in the **build.gradle** file:
```
implementation files ("libs/MathViewer_2.0.0.aar")
```

2. Once you've done the previous step, you can create a MathViewer from the **XML** view of your activity or fragment.
```
<com.fundevs.mathviewer.MathViewer
        android:id="@+id/math_viewer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center" />
```

3. You will be able to link the view with the code and modify its parameters we will use some lines of code. We then observe this with an activity:
```
val mathViewer: MathViewer = findViewById(R.id.mathViewer)
val formula: String = "\$\$e=mc^2\$\$"

mathViewer.setTextColor("#000000")
mathViewer.setFormula(formula)
mathViewer.setTextSize(22)
```
