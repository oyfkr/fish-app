import { createRouter, createWebHashHistory } from "vue-router";

import Login from "@/views/Login.vue";
import LinkMenu from "@/views/LinkMenu.vue";
import SalesRegistration from "@/views/SalesRegistration.vue";
import CompanyRegistration from "@/views/CompanyRegistration.vue";
import ProductRegistration from "@/views/ProductRegistration.vue";

const routes = [
  { path: "/", component: Login },
  { path: "/link-menu", component: LinkMenu },
  { path: "/sales-registration", component: SalesRegistration },
  { path: "/product-registration", component: ProductRegistration },
  { path: "/company-registration", component: CompanyRegistration },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export { router };
