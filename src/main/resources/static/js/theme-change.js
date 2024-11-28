console.log("Loaded");

let current_theme = getTheme();

console.log(current_theme);
toggleTheme(current_theme);
console.log(current_theme);

function getTheme() {
  let theme = localStorage.getItem("theme");
  if (theme === null) return "light";
  else return theme;
}

function setTheme(theme) {
  if (theme != null) {
    localStorage.setItem("theme", theme);
  }
}

function toggleTheme(current_theme) {
  console.log("pressed");

  document.querySelector("html").classList.add(current_theme);
  const change_theme_button = document.querySelector("#theme-change-button");

  change_theme_button.addEventListener("click", () => {
    console.log("clicked");

    //console.log(theme);
    const old_theme = current_theme;

    if (current_theme != null) {
      if (current_theme === "dark") {
        current_theme = "light";
        change_theme_button.querySelector("span").textContent ="Dark";
      } else 
      {
        current_theme = "dark";
        change_theme_button.querySelector("span").textContent ="Light";
      }
      // change_theme_button.querySelector("span").textContent =
      //   current_theme == "dark" ? "Light" : "Dark";
      // change_theme_button.querySelector("span").textContent =
      //   current_theme == "light" ? "Dark" : "Light";
      
    }

    setTheme(current_theme);
    document.querySelector("html").classList.remove(old_theme);

    document.querySelector("html").classList.add(current_theme);
  });
}
