yieldUnescaped '<!DOCTYPE html>'
html {
	head {
		title('Spring One - Groovy templates example')
		link(rel: 'stylesheet', href: '/wro.css')
	}
	body {
		h1("Hello $name")
		ul {
			items.each {
				li("$it".toUpperCase())
			}
		}
		p(messages.get("note"))
	}
}
