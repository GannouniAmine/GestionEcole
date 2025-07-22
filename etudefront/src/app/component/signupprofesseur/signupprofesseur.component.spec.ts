import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupprofesseurComponent } from './signupprofesseur.component';

describe('SignupprofesseurComponent', () => {
  let component: SignupprofesseurComponent;
  let fixture: ComponentFixture<SignupprofesseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SignupprofesseurComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SignupprofesseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
