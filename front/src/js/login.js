const API_URL = "http://fullstack-alb-1823758252.us-east-1.elb.amazonaws.com:8080/auth/login"; 

document.getElementById("loginForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const name = document.getElementById("name").value;
  const password = document.getElementById("password").value;
  const result = document.getElementById("result");

  try {
    const response = await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, password }),
    });

    if (!response.ok) throw new Error("auth error");

    const data = await response.json();

    if (data.token) {
      localStorage.setItem("token", data.token);
      localStorage.setItem("username", data.username);

      result.textContent = "Succeess, redirecting...";
      setTimeout(() => {
        window.location.href = "home.html";
      }, 1000);
    } else {
      result.textContent = " invalid credentials.";
    }
  } catch (error) {
    console.error(error);
    result.textContent = "connection or login error.";
  }
});
