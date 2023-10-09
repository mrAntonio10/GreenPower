import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UsuarioService} from "../../service/usuarioService/usuario.service";
import {LoginI} from "../../model/usuario/usuario";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {
  // @ts-ignore
  form: FormGroup;

  constructor(private router: Router,
              private usuarioService: UsuarioService) {
  }
  ngOnInit() {

    // @ts-ignore
    this.form = new FormGroup({
      nombre:new FormControl('', [Validators.required]),
      password:new FormControl('', [Validators.required]),
    });
  }
  navegar() {
    this.router.navigate(['/menu-principal'])
  }

  submitForm(){
    console.log(this.form.value)
    this.usuarioService.loginResponse(this.form.value).subscribe(data => {
      console.log(data);
      if(data){
        this.router.navigate(['/menu-principal']);
      }
    },  err => {
      console.log(err);
      alert("Usuario no valido en sistema");
    })
  }
}
