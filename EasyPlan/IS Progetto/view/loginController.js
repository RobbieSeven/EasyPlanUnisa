  $(document).ready(function()
      {
        $('#form').submit(function()
        {
          return validateForm();
        });
      });

      function validateUsername(username)
      {
         var letters = /^[0-9a-zA-Z\S]+$/;
         if(username.match(letters))
             return true;
         else
             return false;
      }

      function ValidatePassword(password)
      {
        var passwordformat= /^([A-Za-z0-9]){3,16}$/;

        if(password.match(passwordformat))
        {
          return true;
        }
        else
        {
          return false;
        }
      }

      function validateForm()
      {
      	if($("#username").val() == "" || !validateUsername($("#username").val()))
          {
            alert(" L'username non puo' avere spazi");
            $("#username").focus();
            return false;
          }
          else if($("#password").val() == "" || !ValidatePassword($("#password").val()))
          {
            alert("La pasword deve avere minimo 3 caratteri massimo 16");
            $("#password").focus();
            return false;
          }
          else
          {
            return true;
          }
      }