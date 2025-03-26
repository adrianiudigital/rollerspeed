
document.addEventListener("DOMContentLoaded", function () {
  const token = sessionStorage.getItem("jwt");
  if (!token) {
    window.location.href = "/login";
    return;
  }

  fetch("/mi-usuario", {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  })
    .then((res) => {
      if (!res.ok) throw new Error("No autorizado");
      return res.json();
    })
    .then((user) => {
      document.getElementById("nombreUsuario").textContent = user.username;
      document.getElementById("rolUsuario").textContent = user.role;
    })
    .catch(() => {
      sessionStorage.removeItem("jwt");
      window.location.href = "/login";
    });
});
