package com.roman.Chapter9.InnerClasses;

public class Button {
    private String title;
    private IOnClickListener onClickListener;

    public Button(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(final IOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        this.onClickListener.onClick(this.title);
    }

    public interface IOnClickListener {
        public void onClick(String title);
    }
}
