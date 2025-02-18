import { CanActivateFn } from '@angular/router';


export const guardsGuard: CanActivateFn = (route, state) => {
  let check = '1234';
  let password = prompt("Please enter the password to view this page", "");
  if (password === check) {
    return true;
  }
  alert("Password is incorrect");
  return false;
};
